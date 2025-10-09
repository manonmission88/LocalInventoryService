package com.example.learner.localinventoryservice.service;

import com.example.learner.localinventoryservice.entity.Event;
import com.example.learner.localinventoryservice.entity.Venue;
import com.example.learner.localinventoryservice.repository.EventRepository;
import com.example.learner.localinventoryservice.repository.VenueRepository;
import com.example.learner.localinventoryservice.response.EventInventoryResponse;
import com.example.learner.localinventoryservice.response.VenueInventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        final List<Event> events = eventRepository.findAll();
        return events.stream()
                .map(event -> EventInventoryResponse.builder()
                        .event(event.getName())
                        .capacity(event.getLeftCapacity())
                        .venue(event.getVenue())
                        .build())
                .collect(Collectors.toList());

    }

    public VenueInventoryResponse getVenueInformation(Long venueId){
        final Venue venue = venueRepository.findById(venueId).orElse(null);
        return VenueInventoryResponse.builder()
                .venueId(venue.getId()) // might result in null response
                .venueName(venue.getName())
                .totalCapacity(venue.getTotalCapacity())
                .build();
    }

}
