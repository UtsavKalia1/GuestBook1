package com.example.guestbook1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Component

public class Guest {

    private int Id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    public void configureGuest(){
        System.out.println("***CONFIGURING GUEST ***");
    }
    public void destroy(){
        System.out.println("***DESTROYING GUEST ***");
    }
}
