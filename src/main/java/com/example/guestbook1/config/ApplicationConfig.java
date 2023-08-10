package com.example.guestbook1.config;

import com.example.guestbook1.domain.Guest;
import com.example.guestbook1.service.GuestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration

@PropertySource("classpath:guestapp.properties")
public class ApplicationConfig {
//    @Profile("dev")
//    @Bean(name = "guest")
//    public Guest guest(@Value("${guest.id}") int id,
//                       @Value("${guest.firstName}")String firstName,
//                       @Value("${guest.lastName}")String lastName,
//                       @Value("${guest.phone}")String phone){
//        return Guest.builder().
//                Id(id).
//                firstName(firstName).
//                lastName(lastName).
//                phoneNumber(phone).
//                address(null)
//                .build();
//    }
//    @Profile("prod")
//    @Bean(name = "guest")
//    public Guest guest2(@Value("${guest.id}") int id,
//                       @Value("${guest.firstName}")String firstName,
//                       @Value("${guest.lastName}")String lastName,
//                       @Value("${guest.phone}")String phone){
//        return Guest.builder().
//                Id(id).
//                firstName("utsav").
//                lastName("kalia").
//                phoneNumber("224343433").
//                address(null)
//                .build();
//    }
    @Bean(initMethod = "configureGuest", destroyMethod = "destroy")
    public Guest guest(){
        return Guest.builder().build();
    }
    @Bean()
    public DataSource dataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:h2:./appdb");
        builder.username("sa");
        builder.password("");
        return builder.build();
    }
}
