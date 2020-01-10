package com.zhaoxl.redisdemo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * author: zhaoxl
 * title: DataSourceConfig
 * description: 数据源配置
 * date: 2020年1月9日 15:53:59
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    DataSource primaryDataSource() {
        return DruidDataSourceBuilder.create().build();
    }


    @Bean(name = "jdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(
            @Qualifier("dataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


    @Bean(name = "transactionManager")
    public PlatformTransactionManager primaryTransactionManager(@Qualifier("dataSource") DataSource primaryDataSource) {
        return new DataSourceTransactionManager(primaryDataSource);
    }


}