package com.lld.MovieBookingSystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity         //Convert this class into a table
public class Users extends BaseModel{
    private String name;
    private String email;
    private String password;    //Next step is encryption with Bcrypt
    @OneToMany(mappedBy = "bookedBy")
    private List<Booking> bookings;

}

//User 1: M Booking cardinality
