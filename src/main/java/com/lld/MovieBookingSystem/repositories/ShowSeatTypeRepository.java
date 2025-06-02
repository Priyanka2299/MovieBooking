package com.lld.MovieBookingSystem.repositories;

import com.lld.MovieBookingSystem.models.Show;
import com.lld.MovieBookingSystem.models.ShowSeat;
import com.lld.MovieBookingSystem.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Integer> {
    List<ShowSeatType> findAllByShow(Show show);
}

//select * from showSeatType where show_id = ?;
