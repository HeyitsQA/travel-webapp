package htw.projekt.web_app.travel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TripController {
    @GetMapping("/trips")
    public String getTrips() {
        return "Trip route works!";
    }
}
