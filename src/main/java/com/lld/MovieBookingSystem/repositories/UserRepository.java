package com.lld.MovieBookingSystem.repositories;

import com.lld.MovieBookingSystem.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
}
