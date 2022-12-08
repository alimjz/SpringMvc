package com.digipay.spring.mvc.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
//@EnableJpaRepositories("com.digipay.spring.mvc")
@ComponentScan("com.digipay.spring.mvc")
public class DataConfig {
    private final String PROPERTY_DRIVER = "driver";
    private final String PROPERTY_URL = "url";
    private final String PROPERTY_USERNAME = "user";
    private final String PROPERTY_PASSWORD = "password";
    private final String PROPERTY_SHOW_SQL = "hibernate.show_sql";
    private final String PROPERTY_DIALECT = "hibernate.dialect";
    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManager(){
        LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
        lfb.setDataSource(dataSource());
        lfb.setPackagesToScan("com.digipay.spring.mvc");
        lfb.setJpaProperties(hibernateProps());
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        lfb.setJpaVendorAdapter(vendorAdapter);
        lfb.setPackagesToScan("com.digipay.spring.mvc");
        return lfb;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/usermanagement");
        ds.setUsername("root");
        ds.setPassword("2050534205Ali");
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return ds;
    }


    public Properties hibernateProps(){
        Properties properties = new Properties();
        properties.setProperty(PROPERTY_DIALECT,"org.hibernate.dialect.MySQLDialect");
        properties.setProperty(PROPERTY_SHOW_SQL,"true");
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        return properties;
    }
    @Bean
    public JpaTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager().getObject());
        return transactionManager;
    }



}
