package ru.crynet.spring.multidb.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {
    private static final String entityPackage = "ru.crynet.spring.multidb.entity";

    @Bean
    @Primary
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public HikariDataSource dataSource() {
        return dataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder factoryBuilder) {
        return factoryBuilder
                .dataSource(dataSource())
                .persistenceUnit("default")
                .packages(entityPackage)
                .build();
    }

    @Bean
    @ConfigurationProperties("app.datasource.2018")
    public DataSourceProperties dataSourceProperties2018() {
        return new DataSourceProperties();
    }


    @Bean
    public HikariDataSource dataSource2018() {
        return dataSourceProperties2018().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(EntityManagerFactoryBuilder factoryBuilder) {
        return factoryBuilder
                .dataSource(dataSource2018())
                .persistenceUnit("2018")
                .packages(entityPackage)
                .build();
    }

    @Bean
    @ConfigurationProperties("app.datasource.2019")
    public DataSourceProperties dataSourceProperties2019() {
        return new DataSourceProperties();
    }


    @Bean
    public HikariDataSource dataSource2019() {
        return dataSourceProperties2019().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean thirdEntityManagerFactory(EntityManagerFactoryBuilder factoryBuilder) {
        return factoryBuilder
                .dataSource(dataSource2019())
                .persistenceUnit("2019")
                .packages(entityPackage)
                .build();
    }
}
