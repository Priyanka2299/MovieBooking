package com.lld.MovieBookingSystem.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BookTicketResponseDTO {
    private int bookingId;
    private int amount;
    private ResponseStatus responseStatus;

}
