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

    // Get all places by trip ID
    @GetMapping("/trip/{tripId}")
    public List<Place> getPlacesByTrip(@PathVariable Long tripId) {
        return placeRepository.findByTripId(tripId);
    }

    // Get single place by ID
    @GetMapping("/{id}")
    public ResponseEntity<Place> getPlaceById(@PathVariable Long id) {
        return placeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create new place
    @PostMapping
    public ResponseEntity<Place> createPlace(@RequestBody Place place) {
        Place saved = placeRepository.save(place);
        return ResponseEntity.ok(saved);
    }

    // Update place (including rating)
    @PutMapping("/{id}")
    public ResponseEntity<Place> updatePlace(@PathVariable Long id, @RequestBody Place placeDetails) {
        return placeRepository.findById(id)
                .map(place -> {
                    place.setName(placeDetails.getName());
                    place.setCategory(placeDetails.getCategory());
                    place.setStatus(placeDetails.getStatus());
                    place.setNotes(placeDetails.getNotes());
                    place.setRating(placeDetails.getRating());
                    place.setLatitude(placeDetails.getLatitude());
                    place.setLongitude(placeDetails.getLongitude());
                    place.setVisitDate(placeDetails.getVisitDate());
                    place.setUpdatedAt(java.time.LocalDateTime.now());
                    Place updated = placeRepository.save(place);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete place
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        placeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
