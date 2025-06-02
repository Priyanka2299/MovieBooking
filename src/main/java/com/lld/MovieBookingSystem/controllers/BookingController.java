package com.lld.MovieBookingSystem.controllers;

import com.lld.MovieBookingSystem.dtos.BookTicketRequestDTO;
import com.lld.MovieBookingSystem.dtos.BookTicketResponseDTO;
import com.lld.MovieBookingSystem.dtos.ResponseStatus;
import com.lld.MovieBookingSystem.models.Booking;
import com.lld.MovieBookingSystem.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    private BookingService bookingService;
    @Autowired                  //here by Autowired, we are saying inject the booking Service over here
    BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO request){
        BookTicketResponseDTO response = new BookTicketResponseDTO();
        try{
            Booking booking = bookingService.bookTicket(
                    request.getShowSeatIds(),
                    request.getUserId(),
                    request.getShowId()
            );
            response.setBookingId(booking.getId());
            response.setAmount(booking.getAmount());
            response.setResponseStatus(ResponseStatus.SUCCESS);

        } catch(Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
