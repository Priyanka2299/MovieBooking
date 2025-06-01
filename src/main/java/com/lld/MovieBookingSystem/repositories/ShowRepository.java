package com.lld.MovieBookingSystem.repositories;

import com.lld.MovieBookingSystem.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
    @Override
    Optional<Show> findById(Integer integer);


}

//Models
//Repositories
//Spring Data JPA: Interface
//Hibernate: ORM
//Hibernate is the one who actually go and execute the query.
// But Hibernate someone to say what needs to be implement
//Spring Data JPA is like an interface which has all the information which needs to be implemented
// from which Hibernate gets to know all of these functions are required
