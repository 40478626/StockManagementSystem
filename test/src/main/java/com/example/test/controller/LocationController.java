package com.example.test.controller;

import com.example.test.Location;
import com.example.test.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public List<Location> getALlUsers(){
        return locationService.getAllLocations();
    }

    @GetMapping("/locations/{id}")
    public Location getLocation(@PathVariable String id){
        return locationService.getLocation(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/locations")
    public void addLocation(@RequestBody Location location){
        locationService.addLocation(location);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/locations/{id}")
    public void deleteLocation( @PathVariable String id){
        locationService.deleteLocation(id);
    }

    @RequestMapping(value = "/locations/{id}",method = RequestMethod.PUT)
    public void updateLocation(@RequestBody Location location, @PathVariable String id){

        locationService.updateLocation(id, location);
    }
}
