package com.example.test.service;

import org.springframework.stereotype.Service;
import com.example.test.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LocationService {
    Location location1 = new Location("l1", "Mayungone");
    Location location2 = new Location("l2", "NorthDagon");
    Location location3 = new Location("l3", "Alone");
    List<Location> locations = new ArrayList<>(Arrays.asList(location1, location2, location3));

    public List<Location> getAllLocations(){
        return locations;
    }

    public Location getLocation(String id){
        Location location = locations.stream().filter(t->id.equals(t.getId())).findFirst().orElse(null);

        return location;
    }

    public void addLocation(Location location){
        locations.add(location);
    }

    public void deleteLocation(String id) {
        locations.removeIf(t-> t.getId().equals(id));
    }

    public void updateLocation(String id, Location location) {
        for (int i = 0; i < locations.size(); i++){
            Location l = locations.get(i);
            if (l.getId().equals(id)){
                locations.set(i,location);
            }
        }
    }
}
