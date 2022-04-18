package com.amigoscode.springbootexample.modules.student.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("datasource")
public class DataSourceProperties {

    private String dbUrl;
    private String dbUsername;
    private String dbPassword;
    private String dbSchema;
    private Integer poolSize;
    private Integer maxLifetime;
    private String driverDatabase;
    private String execucaoDll;
    private String dialect;
    private String physicalNamingStrategy;

    public DataSourceProperties() {
    }

    public DataSourceProperties(String dbUrl,
                                String dbUsername,
                                String dbPassword,
                                String dbSchema,
                                Integer poolSize,
                                Integer maxLifetime,
                                String driverDatabase,
                                String execucaoDll,
                                String dialect,
                                String physicalNamingStrategy) {
        this.dbUrl = dbUrl;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
        this.dbSchema = dbSchema;
        this.poolSize = poolSize;
        this.maxLifetime = maxLifetime;
        this.driverDatabase = driverDatabase;
        this.execucaoDll = execucaoDll;
        this.dialect = dialect;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbSchema() {
        return dbSchema;
    }

    public void setDbSchema(String dbSchema) {
        this.dbSchema = dbSchema;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public Integer getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(Integer poolSize) {
        this.poolSize = poolSize;
    }

    public Integer getMaxLifetime() {
        return maxLifetime;
    }

    public void setMaxLifetime(Integer maxLifetime) {
        this.maxLifetime = maxLifetime;
    }

    public String getDriverDatabase() {
        return driverDatabase;
    }

    public void setDriverDatabase(String driverDatabase) {
        this.driverDatabase = driverDatabase;
    }

    public String getExecucaoDll() {
        return execucaoDll;
    }

    public void setExecucaoDll(String execucaoDll) {
        this.execucaoDll = execucaoDll;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getPhysicalNamingStrategy() {
        return physicalNamingStrategy;
    }

    public void setPhysicalNamingStrategy(String physicalNamingStrategy) {
        this.physicalNamingStrategy = physicalNamingStrategy;
    }
}
