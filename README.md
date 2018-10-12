## spring cloud


### 整合sharding jdbc 实现读写分离

1.引入sharding jdbc 依赖
```
    <dependency>
        <groupId>io.shardingsphere</groupId>
        <artifactId>sharding-jdbc-spring-boot-starter</artifactId>
        <version>${sharding-sphere-version}</version>
    </dependency>
    <dependency>
        <groupId>io.shardingsphere</groupId>
        <artifactId>sharding-jdbc-spring-namespace</artifactId>
        <version>${sharding-sphere-version}</version>
    </dependency>
```

2.sharding jdbc配置
有两种方式可以配置sharding jdbc,Java代码或者是yml文件，这里选择的是yml文件，直接在application.yml中增加配置

```
sharding:
  jdbc:
    datasource:
      names: resources-m-0,resources-s-0
      resources-m-0:
        url: jdbc:mysql://localhost:33062/resources?useUnicode=true&characterEncoding=utf8&verifyServerCertificate=false&useSSL=true
        driver-class-name: com.mysql.jdbc.Driver
        username: root
        password: root
        initialSize: 1
        minIdle: 1
        maxActive: 20
        maxWait: 60000
        timeBetweenEvictionRunsMillis: 60000
        minEvictableIdleTimeMillis: 300000
        type: com.alibaba.druid.pool.DruidDataSource
      resources-s-0:
        url: jdbc:mysql://localhost:3306/resources?useUnicode=true&characterEncoding=utf8&verifyServerCertificate=false&useSSL=true
        driver-class-name: com.mysql.jdbc.Driver
        username: root
        password: root
        initialSize: 1
        minIdle: 1
        maxActive: 20
        maxWait: 60000
        timeBetweenEvictionRunsMillis: 60000
        minEvictableIdleTimeMillis: 300000
        type: com.alibaba.druid.pool.DruidDataSource
    config:
      sharding:
        master-slave-rules:
          dbs_0:
            masterDataSourceName: resources_m_0
            slaveDataSourceNames: resources_s_0
        props:
          sql.show: true
```

其他配置不变，sharding jdbc配置完毕。

### 配置中心参数加密

在Git仓库中存储配置信息都是明文，但在某些场景下，一些比较敏感的内容（如数据库账号与密码），不易以明文存储，应当加密存储。Config Server为配置内容的加密与解密提供了很好地支持。

#### 安装JCE

config server的加解密功能依赖于Java的Java Cryptography Extension（JCE）模块，故需要先安装JCE.

jdk8 JCE下载地址
```
http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html 。
```

下载后解压jce文件夹，将文件拷贝到 java_home/jre/lib/security下即可。
sharding.jdbc.datasource.names=resources-m-0,resources-s-0
sharding:
  jdbc:
    datasource:
      sharding.jdbc.datasource.names=resources-m-0,resources-s-0
      sharding.jdbc.datasource.resources-m-0.
        sharding.jdbc.datasource.resources-m-0.url: jdbc:mysql://localhost:33062/resources?useUnicode=true&characterEncoding=utf8&verifyServerCertificate=false&useSSL=true
        sharding.jdbc.datasource.resources-m-0.driver-class-name: com.mysql.jdbc.Driver
        sharding.jdbc.datasource.resources-m-0.username: root
        sharding.jdbc.datasource.resources-m-0.password: root
        sharding.jdbc.datasource.resources-m-0.initialSize: 1
        sharding.jdbc.datasource.resources-m-0.minIdle: 1
        sharding.jdbc.datasource.resources-m-0.maxActive: 20
        sharding.jdbc.datasource.resources-m-0.maxWait: 60000
        sharding.jdbc.datasource.resources-m-0.timeBetweenEvictionRunsMillis: 60000
        sharding.jdbc.datasource.resources-m-0.minEvictableIdleTimeMillis: 300000
        sharding.jdbc.datasource.resources-m-0.type: com.alibaba.druid.pool.DruidDataSource
        sharding.jdbc.datasource.resources-s-0.url: jdbc:mysql://localhost:3306/resources?useUnicode=true&characterEncoding=utf8&verifyServerCertificate=false&useSSL=true
        sharding.jdbc.datasource.resources-s-0.driver-class-name: com.mysql.jdbc.Driver
        sharding.jdbc.datasource.resources-s-0.username: root
        sharding.jdbc.datasource.resources-s-0.password: root
        sharding.jdbc.datasource.resources-s-0.initialSize: 1
        sharding.jdbc.datasource.resources-s-0.minIdle: 1
        sharding.jdbc.datasource.resources-s-0.maxActive: 20
        sharding.jdbc.datasource.resources-s-0.maxWait: 60000
        sharding.jdbc.datasource.resources-s-0.timeBetweenEvictionRunsMillis: 60000
        sharding.jdbc.datasource.resources-s-0.minEvictableIdleTimeMillis: 300000
        sharding.jdbc.datasource.resources-s-0.type: com.alibaba.druid.pool.DruidDataSource
            sharding.jdbc.config.sharding.master-slave-rules.dbs_0.masterDataSourceName: resources_m_0
            sharding.jdbc.config.sharding.master-slave-rules.dbs_0.slaveDataSourceNames: resources_s_0
          sharding.jdbc.config.sharding.props.sql.show: true

