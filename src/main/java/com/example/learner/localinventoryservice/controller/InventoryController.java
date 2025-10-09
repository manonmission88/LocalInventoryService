package com.example.learner.localinventoryservice.controller;

import ch.qos.logback.classic.pattern.ClassOfCallerConverter;
import com.example.learner.localinventoryservice.response.EventInventoryResponse;
import com.example.learner.localinventoryservice.response.VenueInventoryResponse;
import com.example.learner.localinventoryservice.service.LocalInventoryService;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InventoryController
{
    // this controller going to return the multiple events
    private final LocalInventoryService localInventoryService;

    @Autowired
    public InventoryController(final LocalInventoryService localInventoryService){
        this.localInventoryService = localInventoryService;
    }
    @GetMapping("/inventory/events")
    public @ResponseBody List<EventInventoryResponse> inventoryGetAllEvents(){
        return localInventoryService.getAllEvents();
    }

    @GetMapping("/inventory/venue/{venueId}")
    public @ResponseBody VenueInventoryResponse inventoryGetVenueById(@PathVariable Long venueId){
        return localInventoryService.getVenueInformation(venueId);
    }

}
