package com.atomikos.atomikosdemo.config;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;
import java.sql.SQLException;

/**
 * @author derrick.yang
 * @Date 12/25/18 10:38 AM
 */

@Configuration
@EnableTransactionManagement
@ComponentScan
@Data
@MapperScan(basePackages = "com.atomikos.atomikosdemo.dao2", sqlSessionTemplateRef = "webSqlSessionTemplate")
public class ResourceDataSourceConfig {
    // 配置数据源
    @Primary
    @Bean(name = "web",initMethod="init",destroyMethod="close")
    public DataSource dataSource() throws SQLException {
        DruidXADataSource dataSource=new DruidXADataSource();
        //DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://39.107.97.132:3306/resource?useUnicode=true&characterEncoding=utf8&verifyServerCertificate=false&useSSL=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        //配置最大连接
        dataSource.setMaxActive(300);
        //配置初始连接
        dataSource.setInitialSize(20);
        //配置最小连接
        dataSource.setMinIdle(10);
        //连接等待超时时间
        dataSource.setMaxWait(60000);
        //间隔多久进行检测,关闭空闲连接
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        //一个连接最小生存时间
        dataSource.setMinEvictableIdleTimeMillis(300000);
        //连接等待超时时间 单位为毫秒 缺省启用公平锁，
        //并发效率会有所下降， 如果需要可以通过配置useUnfairLock属性为true使用非公平锁
        dataSource.setUseUnfairLock(true);
        //用来检测是否有效的sql
        dataSource.setValidationQuery("select 'x'");
        dataSource.setTestWhileIdle(true);
        //申请连接时执行validationQuery检测连接是否有效，配置为true会降低性能
        dataSource.setTestOnBorrow(false);
        //归还连接时执行validationQuery检测连接是否有效，配置为true会降低性能
        dataSource.setTestOnReturn(false);
        //打开PSCache,并指定每个连接的PSCache大小启用poolPreparedStatements后，
        //PreparedStatements 和CallableStatements 都会被缓存起来复用，
        //即相同逻辑的SQL可以复用一个游标，这样可以减少创建游标的数量。
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxOpenPreparedStatements(20);
        //配置sql监控的filter
        dataSource.setFilters("stat,wall,log4j");
        try {
            dataSource.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(dataSource);
        xaDataSource.setUniqueResourceName("testDataSource");

        return xaDataSource;
    }


    @Bean(name = "webSqlSessionFactory")
    public SqlSessionFactory webSqlSessionFactory(@Qualifier("web") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:sql-mapper/res/*.xml"));
        return bean.getObject();
    }


    @Bean(name = "webSqlSessionTemplate")
    public SqlSessionTemplate webSqlSessionTemplate(
            @Qualifier("webSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
