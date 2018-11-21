package com.sxli.druiddemo.beans;

import com.alibaba.druid.pool.DruidDataSource;
import com.sxli.druiddemo.config.JdbcProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidDataSourceBean {

    @Autowired
    private JdbcProperties config;

    @Bean
    public DataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setMaxActive(config.getMaxActive());
        dataSource.setMinIdle(config.getMinIdle());
        dataSource.setDbType(config.getDbType());
        dataSource.setDriverClassName(config.getDriverClassName());
        dataSource.setUsername(config.getUserName());
        dataSource.setPassword(config.getPassword());
        dataSource.setUrl(config.getUrl());
        return dataSource;
    }
}
