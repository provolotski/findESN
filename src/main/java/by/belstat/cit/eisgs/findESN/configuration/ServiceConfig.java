package by.belstat.cit.eisgs.findESN.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
@ComponentScan({"by.belstat.cit.eisgs.findESN.services",
"by.belstat.cit.eisgs.findESN.dao"})
public class ServiceConfig {
    private static final Logger LOGGER = LogManager.getLogger(ServiceConfig.class);
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() throws IOException {
        LOGGER.debug("start placeholderConfigurer bean");
        PropertySourcesPlaceholderConfigurer conf = new PropertySourcesPlaceholderConfigurer();
        conf.setLocations(getResources());
        return conf;
    }

    private static Resource[] getResources(){
        return new Resource[] {new ClassPathResource("db.properties")};
    }
}
