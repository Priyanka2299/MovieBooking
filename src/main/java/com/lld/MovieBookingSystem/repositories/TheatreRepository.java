package com.lld.MovieBookingSystem.repositories;

import com.lld.MovieBookingSystem.models.Theatre;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
}
