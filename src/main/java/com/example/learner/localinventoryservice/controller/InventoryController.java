package com.example.learner.localinventoryservice.controller;

import ch.qos.logback.classic.pattern.ClassOfCallerConverter;
import com.example.learner.localinventoryservice.response.EventInventoryResponse;
import com.example.learner.localinventoryservice.service.LocalInventoryService;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class InventoryController
{
    // this controller going to return the multiple events
    private LocalInventoryService localInventoryService;

    @Autowired
    public InventoryController(final LocalInventoryService localInventoryService){
        this.localInventoryService = localInventoryService;
    }
    @GetMapping("/inventory/events")
    public @ResponseBody List<EventInventoryResponse> inventoryGetAllEvents(){
        return localInventoryService.getAllEvents();
    }
}
