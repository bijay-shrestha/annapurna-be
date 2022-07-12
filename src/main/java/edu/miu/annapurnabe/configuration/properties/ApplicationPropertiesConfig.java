package edu.miu.annapurnabe.configuration.properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author bijayshrestha on 7/6/22
 * @project annapurna-be
 */
@Configuration
@PropertySource("classpath:security.properties")
public class ApplicationPropertiesConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
