# druid-demo
阿里巴巴Druid连接池结合SpringBoot使用案例
# 参考文档 
Oracle数据库下PreparedStatementCache内存问题解决方案
https://github.com/alibaba/druid/wiki/Oracle%E6%95%B0%E6%8D%AE%E5%BA%93%E4%B8%8BPreparedStatementCache%E5%86%85%E5%AD%98%E9%97%AE%E9%A2%98%E8%A7%A3%E5%86%B3%E6%96%B9%E6%A1%88
# 访问监控地址
http://localhost:8080/druid/index.html
# 注意
不支持游标的数据如MYSQL不建议开启PSCache，性能上不会出现很大提升的同时会带来内存损耗过大的问题，严重会导致FULL GC以及内存溢出等问题