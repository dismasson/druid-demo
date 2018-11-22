package com.sxli.druiddemo.beans;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import com.sxli.druiddemo.config.JdbcProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义druid相关bean
 */
@Configuration
public class DruidDataSourceBean {

    @Autowired
    private JdbcProperties config;

    /**
     * druid数据源
     *
     * @return
     * @throws SQLException
     */
    @Bean
    public DataSource druidDataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setMaxActive(config.getMaxActive());
        dataSource.setMinIdle(config.getMinIdle());
        dataSource.setDbType(config.getDbType());
        dataSource.setDriverClassName(config.getDriverClassName());
        dataSource.setUsername(config.getUserName());
        dataSource.setPassword(config.getPassword());
        dataSource.setUrl(config.getUrl());
        // 配置空闲连接测试
        dataSource.setTestWhileIdle(config.isTestWhileIdle());
        // 配置空闲连接测试SQL语句
        dataSource.setValidationQuery(config.getValidationQuery());
        List<Filter> filters = new ArrayList<>();
        // 将SQL过滤器加入到过滤器集合中
        filters.add(wallFilter());
        // 将SQL记录过滤器加入到过滤器集合中
        filters.add(statFilter());
        // 将过滤器集合加入到数据源的过滤器集合
        dataSource.setProxyFilters(filters);
        return dataSource;
    }

    /**
     * 防止SQL注入具体配置
     *
     * @return
     */
    public WallConfig wallConfig() {
        WallConfig wallConfig = new WallConfig();
        // 设置不允许用select * from table这种查询方式，select * from (select id,name from user) u允许
        wallConfig.setSelectAllColumnAllow(false);
        return wallConfig;
    }

    /**
     * SQL过滤器
     *
     * @return
     */
    public WallFilter wallFilter() {
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig());
        return wallFilter;
    }

    /**
     * SQL记录过滤器
     *
     * @return
     */
    public StatFilter statFilter() {
        StatFilter statFilter = new StatFilter();
        // 开启慢SQL记录
        statFilter.setLogSlowSql(true);
        // 设置多长执行时间算慢SQL,单位为毫秒，此刻没有那么大数据量，用一个小值模拟
        statFilter.setSlowSqlMillis(5);
        // sql合并，如select id from user where id = 1这种格式的，可以合并成select id from user where id = ？
        statFilter.setMergeSql(true);
        return statFilter;
    }
}
