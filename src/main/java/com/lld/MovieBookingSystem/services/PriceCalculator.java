package com.lld.MovieBookingSystem.services;

import com.lld.MovieBookingSystem.models.*;
import com.lld.MovieBookingSystem.repositories.ShowSeatRepository;
import com.lld.MovieBookingSystem.repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceCalculator {
    @Autowired
    private ShowSeatRepository showSeatRepository;
    private ShowSeatTypeRepository showSeatTypeRepository;

    public Integer calculatePrice(List<ShowSeat> showSeats){
        int amount =0;
        Show show = showSeats.get(0).getShow();
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

        for(ShowSeat showSeat: showSeats){
            for(ShowSeatType showSeatType: showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatType )){
                    amount += showSeatType.getPrice();
                    break;
                }
            }

        }
        return amount;
    }
}
