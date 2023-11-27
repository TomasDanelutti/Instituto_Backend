package com.example.institutoBackend.system;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class AppConfig {

    @Bean("dataSource")
    public DataSource dataSource() {
        var dbServerUrl = "jdbc:postgresql://localhost:5432/instituto";

        return DataSourceBuilder.create().driverClassName("org.postgresql.Driver").url(dbServerUrl)
                .username("postgres").password("40971194").build();

    }

    @Bean("entityManagerFactory")
    public SessionFactory getEntityManagerFactory(DataSource dataSource) {

        Properties properties = new Properties();
        properties.put("hibernate.hbm2ddl.auto", "update");
//        properties.put("hibernate.default_schema", "miconsultorio");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.jdbc.lob.non_contextual_creation", true);

        LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionFactoryBuilder.scanPackages("com.example.institutoBackend.model");
        sessionFactoryBuilder.addProperties(properties);
        return sessionFactoryBuilder.buildSessionFactory();
    }

    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new HibernateTransactionManager(entityManagerFactory.unwrap(SessionFactory.class));
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public JavaMailSender getJavaMailSender() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setDefaultEncoding("UTF-8");
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("tomasdanelutti12@gmail.com");
        mailSender.setPassword("xwdh oqyr czca xigf");
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        return mailSender;
    }

    @Bean("serverUrl")
    public String getServerUrl() {

        String serverUrl = "http://localhost:8100/#/";

        return serverUrl;
    }

    @Bean
    public SessionFactory sessionFactory(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.unwrap(SessionFactory.class);
    }
    

}
