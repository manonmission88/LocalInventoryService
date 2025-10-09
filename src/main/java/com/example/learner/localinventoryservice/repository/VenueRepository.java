package com.example.learner.localinventoryservice.repository;

import com.example.learner.localinventoryservice.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// each table going to have repository class
// spring will know what are the columns associated with the objects
@Repository
public interface VenueRepository extends JpaRepository<Venue, Long> {
}
