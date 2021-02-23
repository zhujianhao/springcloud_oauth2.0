# springcloud_oauth2.0
基于springcloud 和 oauth2.0的后台服务端基础框架 可直接使用

### 1.请自行创建account 表 
### 2.百度oauth2.0 需要的数据库表 并创建
### 3.需要在nacos添加ls-wechat.yml datasource.yml ls-oauth.yml ls-gateway四个配置文件   datasource.yml中 需要配置数据库信息 mybatis-plus 
```
spring:
  datasource:
    url: jdbc:mysql://ip:3306/lsgym?useUnicode=true&useSSL=false&characterEncoding=utf8&rewriteBatchedStatements=true&characterSetResults=utf8&serverTimezone=GMT%2B8
    username: user
    password: pass
    type: com.alibaba.druid.pool.DruidDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver

    druid:
      initialSize: 5
      minIdle: 5
      maxActive: 20
      maxWait: 60000
      timeBetweenEvictionRunsMillis: 60000
      minEvictableIdleTimeMillis: 300000
      validationQuery: SELECT 1 FROM DUAL
      testWhileIdle: true
      testOnBorrow: true
      testOnReturn: false
      poolPreparedStatements: true
      maxPoolPreparedStatementPerConnectionSize: 20
      filter:
        stat:
          merge-sql: true
          slow-sql-millis: 5000
  

mybatis-plus:
  mapper-locations: mapper/**.xml
  typeAliasesPackage: com.lsgym..**.entity.**
  global-config:
    db-config:
      id-type: ID_WORKER_STR
  configuration:
    map-underscore-to-camel-case: true
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl

feign:
  client:
    config:
      default:
        connectTimeout: 10000
        readTimeout: 60000

```
