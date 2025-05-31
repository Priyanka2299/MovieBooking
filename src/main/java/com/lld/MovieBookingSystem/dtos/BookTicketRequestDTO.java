package com.lld.MovieBookingSystem.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class BookTicketRequestDTO {
    private List<Integer> ShowSeatIds;
    private Integer showId;
    private Integer userId;

}

//Assuming that before booking the seats, the below calls has already happened:-
//1. getMovies
//2. getShows
//3. getShowSeats
//4. bookTicket
