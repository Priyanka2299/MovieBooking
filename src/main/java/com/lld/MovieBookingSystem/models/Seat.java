package com.lld.MovieBookingSystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private String seatNo;
    private int rowVal;
    private int colVal;
    @ManyToOne
    private SeatType seatType;


}

//Seat M : 1 SeatType
