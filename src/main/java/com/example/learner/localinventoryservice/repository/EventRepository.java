package com.example.learner.localinventoryservice.repository;

import com.example.learner.localinventoryservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event
        ,Long> {

}
