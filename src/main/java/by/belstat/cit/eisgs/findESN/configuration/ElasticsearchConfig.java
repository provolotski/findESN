package by.belstat.cit.eisgs.findESN.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "by.belstat.cit.eisgs.findESN.repository")
@ComponentScan(basePackages = {"by.belstat.cit.eisgs.findESN.services"})
public class ElasticsearchConfig {
    private  static final Logger LOGGER = LogManager.getLogger(ElasticsearchConfig.class);

    @Bean
    public RestHighLevelClient client() {
        LOGGER.debug("starting  Elasticsearch RestHighLevelClient bean");
        ClientConfiguration clientConfiguration = null;
        try { clientConfiguration = ClientConfiguration.builder().connectedTo("localhost:9200").build();
            LOGGER.debug("starting  Elasticsearch RestHighLevelClient bean step2");
            return RestClients.create(clientConfiguration).rest();
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        LOGGER.debug("starting  Elasticsearch ElasticsearchOperations bean");
        return new ElasticsearchRestTemplate(client());
    }

}
