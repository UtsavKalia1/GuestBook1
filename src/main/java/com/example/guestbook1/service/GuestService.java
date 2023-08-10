package com.example.guestbook1.service;

import com.example.guestbook1.domain.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class GuestService {
 //CRUD
    private JdbcTemplate template;

    public GuestService(JdbcTemplate template) {
        this.template = template;
    }


    public int createGuest(Guest guest){
        String sql = "INSERT INTO GUESTS VALUES(?,?,?,?,?)";
        int i = template.update(sql,guest.getId()
                ,guest.getFirstName()
                ,guest.getLastName()
                ,guest.getPhoneNumber()
                ,guest.getAddress());
        return i;
    }
    public Guest update(Guest guest){
        System.out.println("Called for Guest Service " + guest);
        return null;
    }
    public Guest deleteGuest(Guest guest){
        return null;
    }
    public Guest getGuest(Guest guest){
        return null;
    }
    public List<Guest> getGuest(){

        return this.template.query("SELECT * FROM GUESTS",
                new MyMapper());

    }
}
class MyMapper implements RowMapper<Guest>{

    @Override
    public Guest mapRow(ResultSet rs, int rowNum) throws SQLException {
        Guest guest = new Guest();
        guest.setFirstName(rs.getString(1));
        return  guest;
    }
}
