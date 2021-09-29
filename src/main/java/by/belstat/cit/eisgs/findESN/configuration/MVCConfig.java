package by.belstat.cit.eisgs.findESN.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
//@EnableSpringDataWebSupport
@ComponentScan({ "by.belstat.cit.eisgs.findESN.controller" })
public class MVCConfig {
}
