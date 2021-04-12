## 探索者联盟

## 资料
[Spring文档](https://spring.io/guides)  
[Spring Web文档](https://spring.io/guides/gs/serving-web-content/)  
[es社区](https://elasticsearch.cn/explore)           
[Github deploy key](https://docs.github.com/en/developers/overview/managing-deploy-keys#deploy-keys)  
[Bootstrap](https://v3.bootcss.com/getting-started/)  
[Github OAuth](https://docs.github.com/en/developers/apps/creating-an-oauth-app)  
[MyBatis-Spring-Boot](http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)  
[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)
## 工具
[Git](https://git-scm.com/download)  
[flyway](https://flywaydb.org/documentation/getstarted/firststeps/maven)  
[Lombok](https://projectlombok.org/)
##脚本
```sql
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_id` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `token` char(36) DEFAULT NULL,
  `gmt_create` bigint DEFAULT NULL,
  `gmt_modified` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
```


```bash
mvn flyway:migrate
```