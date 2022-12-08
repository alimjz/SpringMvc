package com.digipay.spring.mvc.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.digipay.spring.mvc")
@ComponentScan("com.digipay.spring.mvc")
public class DataConfig {
    private final String PROPERTY_DRIVER = "driver";
    private final String PROPERTY_URL = "url";
    private final String PROPERTY_USERNAME = "user";
    private final String PROPERTY_PASSWORD = "password";
    private final String PROPERTY_SHOW_SQL = "hibernate.show_sql";
    private final String PROPERTY_DIALECT = "hibernate.dialect";
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
        lfb.setDataSource(datasource());
        lfb.setPackagesToScan("com.digipay.spring.mvc");
        lfb.setJpaProperties(hibernateProps());
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        lfb.setJpaVendorAdapter(vendorAdapter);
        lfb.setPackagesToScan("com.digipay.spring.mvc");
        return lfb;
    }


}
