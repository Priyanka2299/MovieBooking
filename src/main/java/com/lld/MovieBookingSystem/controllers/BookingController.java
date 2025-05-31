package com.lld.MovieBookingSystem.controllers;

import com.lld.MovieBookingSystem.dtos.BookTicketRequestDTO;
import com.lld.MovieBookingSystem.dtos.BookTicketResponseDTO;
import com.lld.MovieBookingSystem.dtos.ResponseStatus;
import com.lld.MovieBookingSystem.models.Booking;
import com.lld.MovieBookingSystem.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    BookTicketResponseDTO bookTicket(BookTicketRequestDTO request){
        BookTicketResponseDTO response = new BookTicketResponseDTO();
        try{
            Booking booking = bookingService.bookTicket();
            response.setBookingId(booking.getId());
            response.setAmount(booking.getAmount());
            response.setResponseStatus(ResponseStatus.SUCCESS);

        } catch(Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
