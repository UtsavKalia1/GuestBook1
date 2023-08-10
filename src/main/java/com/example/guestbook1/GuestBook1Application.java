package com.example.guestbook1;

import com.example.guestbook1.config.ApplicationConfig;
import com.example.guestbook1.domain.Address;
import com.example.guestbook1.domain.Guest;
import com.example.guestbook1.service.GuestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class GuestBook1Application {

    public static void main(String[] args) {
      ApplicationContext context =  SpringApplication.run(GuestBook1Application.class, args);
        GuestService guestService = context.getBean("guestService", GuestService.class);
        //guestService.createGuest(context.getBean("guest", Guest.class));
        Guest guest = Guest
                .builder()
                .Id(10)
                .firstName("Utsav")
                .lastName("Kaliaa")
                .phoneNumber("1234")
                .address("Hamilton")
                .build();
        guestService.createGuest(guest);
        System.out.println(guestService.getGuest());

    }

}
