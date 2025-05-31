package com.lld.MovieBookingSystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name ="shows")
public class Show extends BaseModel{
    private Date startTime;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Screen screen;
    @OneToMany
    private List<ShowSeat> showSeats;
    @OneToMany
    private List<ShowSeatType> showSeatTypes;

}

//price: Show Seat
//Show M: 1 Screen

//Show 1 : M ShowSeats