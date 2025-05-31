package com.lld.MovieBookingSystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    @ManyToOne
    private Users bookedBy;
    private Date date;
    private int amount;
    @ManyToMany
    private List<ShowSeat> showSeats;
    @OneToMany
    private List<Payment> payments;
    @Enumerated(value = EnumType.STRING)
    private BookingStatus status;

}


//booking M : 1 User
//Booking 1: M ShowSeat but in cancelled cases you have M:M (in one booking showseats which are confirmed and which are cancelled)
// Booking 1: M Payment -> One Payment will be associated with 1 booking only
//The @Enumerated annotation in Spring Boot (actually from JPA, part of Jakarta Persistence)
// used to tell JPA how to save enum values in a database column — either as a name or an ordinal number.
//EnumType.STRING	Stores the enum name as a String in DB (e.g., "ACTIVE")
//EnumType.ORDINAL	Stores the enum ordinal (index) in DB (e.g., 0, 1, 2): Bealdung
