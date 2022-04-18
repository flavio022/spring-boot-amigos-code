package com.amigoscode.springbootexample.modules.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DataSourceConfiguration {

    private DataSourceProperties dataSourceProperties;

    public DataSourceConfiguration(DataSourceProperties dataSourceProperties){
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setUrl(this.dataSourceProperties.getDbUrl());
        dataSource.setUsername(this.dataSourceProperties.getDbUsername());
        dataSource.setPassword(this.dataSourceProperties.getDbPassword());
        dataSource.setSchema(this.dataSourceProperties.getDbSchema());
        dataSource.setDriverClassName(this.dataSourceProperties.getDriverDatabase());

        return dataSource;
        }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource){

        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
                = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPackagesToScan("com.amigoscode.springbootexample.modules.student.entities.*");
        entityManagerFactoryBean.setJpaProperties(additionalProperties());

        return entityManagerFactoryBean;
    }

    private Properties additionalProperties() {

        final Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto",
                this.dataSourceProperties.getExecucaoDll());

        return properties;

    }

}
