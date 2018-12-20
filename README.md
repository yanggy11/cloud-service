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
有两种方式可以配置sharding jdbc,Java代码或者是yml文件，这里选择的是yml文件，直接在application.yml中增加配置，详细配置请参考官方文档。

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


### feigin
1.使用
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

2.feigin拦截器
拦截feigin请求，添加请求header等。实现定义RequestInterceptor接口实现类，在apply方法中添加相应的逻辑，将实现类注册到spring容器中。feiqin调用时，有些敏感header会被丢弃，所以需要在请求之前将需要的header加上。
```
@Configuration
public class FeiginConfiguration {
    @Bean
    public RequestInterceptor headerInterceptor() {
        return (template) -> {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            Enumeration<String> headerNames = request.getHeaderNames();
            if (null != headerNames) {
                while (headerNames.hasMoreElements()) {
                    String name = headerNames.nextElement();
                    String values = request.getHeader(name);
                    template.header(name, values);
                }
            }
        };
    }
}
```


### springboot使用fastjson替换jackson

1.添加fastjson 包
```
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.51</version>
</dependency>
```
2. 定义类继承WebMvcConfigurationSupport，重写configureMessageConverters方法
```
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        // 定义FastJsonHttpMessageConverter
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        // 1.添加fastJson的配置信息，是否要格式化返回的Json数据；
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        // 2、处理中文乱码
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);

        // 3、在convert中添加配置信息；
        fastConverter.setFastJsonConfig(fastJsonConfig);

        // 4、将convert添加到converters当中；
        converters.add(fastConverter);
    }
}
```
