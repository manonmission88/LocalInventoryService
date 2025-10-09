package com.example.learner.localinventoryservice.service;

import com.example.learner.localinventoryservice.response.EventInventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalInventoryService {

    // store all the events
    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;

    @Autowired
    public LocalInventoryService(final EventRepository eventRepository, final VenueRepository venueRepository){
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
    }
    public List<EventInventoryResponse> getAllEvents() {
        // TODO:


    }

}
