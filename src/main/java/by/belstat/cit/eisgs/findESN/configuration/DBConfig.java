package by.belstat.cit.eisgs.findESN.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class DBConfig {
    private static final Logger LOGGER = LogManager.getLogger(DBConfig.class);

    @Autowired
    private ConfigurableEnvironment environment;

    @Bean
    public DataSource dataSource() {
        LOGGER.debug("start dataSource bean");
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.oracle.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.oracle.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.oracle.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.oracle.password"));
        return dataSource;
    }

    private Properties properties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("javax.persistence.validation.mode", "none");
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        return properties;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LOGGER.debug("start session bean");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("by.belstat.cit.eisgs.findESN");
        sessionFactory.setHibernateProperties(properties());
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        LOGGER.debug("start transactionManager bean");
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

}
