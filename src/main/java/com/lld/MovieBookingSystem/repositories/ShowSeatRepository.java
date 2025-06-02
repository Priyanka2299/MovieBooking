package com.lld.MovieBookingSystem.repositories;

import com.lld.MovieBookingSystem.models.Show;
import com.lld.MovieBookingSystem.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {


}
