package htw.projekt.web_app.travel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trips")
@CrossOrigin(origins = "http://localhost:5173")
public class TripController
public class TripController {
    @GetMapping("/trips")
    public List<Trip> getAllTrips() {
        return "Trip route works!";
    }

    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable Long id) {
        return trip.stream().filter(t -> t.getID().equals(id))
    }
}
