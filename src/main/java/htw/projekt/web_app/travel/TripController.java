package htw.projekt.web_app.travel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
@CrossOrigin(origins = {"http://localhost:5173", "https://travel-webapp-frontend.onrender.com", "https://travel-webapp-frontend-9h1q.onrender.com", "https://travel-webapp-frontend-static-site.onrender.com"})
public class TripController {

    @Autowired
    private TripRepository tripRepository;

    @GetMapping
    public List<Trip> getAllTrips(@RequestParam(required = false) String userId) {
        System.out.println("📌 GET /api/trips - Fetching trips for user: " + userId);
        List<Trip> trips = userId != null ? tripRepository.findByUserId(userId) : tripRepository.findAll();
        System.out.println("✅ Found " + trips.size() + " trips");
        return trips;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable Long id) {
        System.out.println("📌 GET /api/trips/" + id + " - Fetching trip by ID");
        return tripRepository.findById(id)
                .map(trip -> {
                    System.out.println("✅ Trip found: " + trip.getName());
                    return ResponseEntity.ok(trip);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip) {
        System.out.println("📝 POST /api/trips - Creating new trip");
        System.out.println("   Name: " + trip.getName());
        System.out.println("   Destination: " + trip.getDestination());
        System.out.println("   Dates: " + trip.getStartDate() + " to " + trip.getEndDate());
        
        Trip saved = tripRepository.save(trip);
        
        System.out.println("✅ Trip saved successfully!");
        System.out.println("   ID: " + saved.getTripId());
        System.out.println("   Created: " + saved.getCreatedAt());
        
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Long id, @RequestBody Trip tripDetails) {
        System.out.println("📝 PUT /api/trips/" + id + " - Updating trip");
        
        return tripRepository.findById(id)
                .map(trip -> {
                    trip.setName(tripDetails.getName());
                    trip.setDestination(tripDetails.getDestination());
                    trip.setStartDate(tripDetails.getStartDate());
                    trip.setEndDate(tripDetails.getEndDate());
                    trip.setStatus(tripDetails.getStatus());
                    trip.setDescription(tripDetails.getDescription());
                    
                    Trip updated = tripRepository.save(trip);
                    System.out.println("✅ Trip updated: " + updated.getName());
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long id) {
        System.out.println("🗑️ DELETE /api/trips/" + id + " - Deleting trip");
        
        if (tripRepository.existsById(id)) {
            tripRepository.deleteById(id);
            System.out.println("✅ Trip deleted");
            return ResponseEntity.noContent().build();
        }
        
        System.out.println("❌ Trip not found");
        return ResponseEntity.notFound().build();
    }
}
