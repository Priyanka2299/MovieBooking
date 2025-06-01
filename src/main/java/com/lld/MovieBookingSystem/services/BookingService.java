package com.lld.MovieBookingSystem.services;

import com.lld.MovieBookingSystem.models.*;
import com.lld.MovieBookingSystem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private BookingRepository bookingRepository;
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    @Autowired                                  //when you write @AUtowired over constructor, all of these things inside constructor will be injected
    BookingService(BookingRepository bookingRepository, UserRepository userRepository,
                   ShowRepository showRepository, ShowSeatRepository showSeatRepository){
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTicket(
            List<Integer> showSeatIds,
            Integer userId,
            Integer showId
    ){
//        1. Get the user from the userId
        Optional<Users> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new RuntimeException("User not found");
        }
        Users user = userOptional.get();
//        2. Get the show from showId
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw new RuntimeException("Show not found");
        }
        Show show = showOptional.get();

//        -----------START TRANSACTION---------------
//        3. Get the ShowSeats from the showSeatIds
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
//        4. Check if all the showSeats are available
        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getSeatStatus().equals(SeatStatus.EMPTY)){
//        6. If not, throw an exception
                throw new RuntimeException("Selected seats not available");
            }
        }
//        5. If all are available, then block the seats
        for(ShowSeat showSeat: showSeats){
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
            showSeat.setBlockedAt(new Date());
        }
//        7. Save the ShowSeats with updated status in the database
        showSeatRepository.saveAll(showSeats);
//        ------------STOP TRANSACTION -----------------
//        8. Create Booking Object and return it
        Booking booking = new Booking();
        booking.setBookedBy(user);
        booking.setDate(new Date());
        booking.setStatus(BookingStatus.PENDING);
        booking.setPayments(new ArrayList<>());
        booking.setShowSeats(showSeats);
        booking.setAmount(100);
        return null;
    }
}

//PriceCalculator Service: to calculatePrice
// To calculate Amount:
// 1. selected showSeats
// 2. find the seatType
// 3. add the corresponding amount in total