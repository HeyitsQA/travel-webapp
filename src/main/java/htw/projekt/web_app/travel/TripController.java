package htw.projekt.web_app.travel;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/trips")
@CrossOrigin(origins = "http://localhost:5173")
public class TripController {

    private List<Trip> trips = new ArrayList<>();

    @GetMapping
    public List<Trip> getAllTrips() {
        return trips;
    }

    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable Long id) {
        return trips.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}