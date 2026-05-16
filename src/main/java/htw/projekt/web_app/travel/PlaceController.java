package htw.projekt.web_app.travel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/places")
@CrossOrigin(origins = {"http://localhost:5173", "https://travel-webapp-frontend.onrender.com"})
public class PlaceController {

    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping("/trip/{tripId}")
    public List<Place> getPlacesByTrip(@PathVariable Long tripId) {
        return placeRepository.findByTripId(tripId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> getPlaceById(@PathVariable Long id) {
        return placeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Place> createPlace(@RequestBody Place place) {
        Place saved = placeRepository.save(place);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        placeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}