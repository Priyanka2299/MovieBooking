package com.lld.MovieBookingSystem.repositories;

import com.lld.MovieBookingSystem.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Integer> {
}
