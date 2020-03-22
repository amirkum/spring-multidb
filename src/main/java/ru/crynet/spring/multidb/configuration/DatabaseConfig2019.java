package ru.crynet.spring.multidb.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig2019 {
    @Bean("dataSourceProperties2019")
    @ConfigurationProperties("app.datasource.2019")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("dataSource2019")
    public HikariDataSource dataSource() {
        return dataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean("entityManagerFactory2019")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder factoryBuilder) {
        return factoryBuilder
                .dataSource(dataSource())
                .persistenceUnit("2019")
                .packages("ru.crynet.spring.multidb.entity")
                .build();
    }
}
