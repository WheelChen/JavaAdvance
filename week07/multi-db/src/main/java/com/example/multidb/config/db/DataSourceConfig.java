package com.example.multidb.config.db;

import com.example.multidb.enums.DBTypeEnum;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kelvin Chen
 * @date 2021-08-09 22:41:26
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    @Qualifier("masterHikariConfig")
    @ConfigurationProperties(prefix="spring.datasource.hikari.master")
    public HikariConfig masterHikariConfig() {
        return new HikariConfig();
    }

    @Bean
    @Primary
    @Qualifier("masterDataSource")
    public DataSource masterDataSource() {
        return new HikariDataSource(masterHikariConfig());
    }

    @Bean
    @Qualifier("slaveHikariConfig")
    @ConfigurationProperties(prefix="spring.datasource.hikari.slave")
    public HikariConfig slaveHikariConfig() {
        return new HikariConfig();
    }

    @Bean
    @Qualifier("slaveDataSource")
    public DataSource slaveDataSource() {
        return new HikariDataSource(slaveHikariConfig());
    }

    @Bean
    public DataSource customRoutingDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                              @Qualifier("slaveDataSource") DataSource slaveDataSource) {

        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.MASTER, masterDataSource);
        targetDataSources.put(DBTypeEnum.SLAVE, slaveDataSource);
        CustomRoutingDataSource customRoutingDataSource = new CustomRoutingDataSource();
        customRoutingDataSource.setDefaultTargetDataSource(masterDataSource);
        customRoutingDataSource.setTargetDataSources(targetDataSources);
        return customRoutingDataSource;
    }

}
