package htw.projekt.web_app.travel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TripControllerTest {

    @Mock
    private TripRepository tripRepository;

    @InjectMocks
    private TripController tripController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Test 1: GET /api/trips returns all trips when no userId filter
    @Test
    void getAllTrips_noFilter_returnsAllTrips() {
        Trip trip1 = new Trip("Paris Trip", "Paris", "2025-06-01", "2025-06-10", "planned");
        Trip trip2 = new Trip("Berlin Trip", "Berlin", "2025-07-01", "2025-07-05", "completed");
        when(tripRepository.findAll()).thenReturn(List.of(trip1, trip2));

        List<Trip> result = tripController.getAllTrips(null);

        assertEquals(2, result.size());
        verify(tripRepository).findAll();
    }

    // Test 2: GET /api/trips?userId=abc returns only that user's trips
    @Test
    void getAllTrips_withUserId_returnsFilteredTrips() {
        Trip trip = new Trip("My Trip", "Rome", "2025-08-01", "2025-08-10", "planned");
        trip.setUserId("user-abc");
        when(tripRepository.findByUserId("user-abc")).thenReturn(List.of(trip));

        List<Trip> result = tripController.getAllTrips("user-abc");

        assertEquals(1, result.size());
        assertEquals("user-abc", result.get(0).getUserId());
        verify(tripRepository).findByUserId("user-abc");
    }

    // Test 3: GET /api/trips/{id} returns 200 when trip exists
    @Test
    void getTripById_exists_returns200() {
        Trip trip = new Trip("Tokyo Trip", "Tokyo", "2025-09-01", "2025-09-15", "planned");
        when(tripRepository.findById(1L)).thenReturn(Optional.of(trip));

        var response = tripController.getTripById(1L);

        assertEquals(200, response.getStatusCode().value());
        assertEquals("Tokyo Trip", response.getBody().getName());
    }

    // Test 4: GET /api/trips/{id} returns 404 when trip does not exist
    @Test
    void getTripById_notFound_returns404() {
        when(tripRepository.findById(99L)).thenReturn(Optional.empty());

        var response = tripController.getTripById(99L);

        assertEquals(404, response.getStatusCode().value());
    }

    // Test 5: POST /api/trips saves and returns the new trip
    @Test
    void createTrip_validTrip_returns200AndSavedTrip() {
        Trip input = new Trip("Lisbon Trip", "Lisbon", "2025-10-01", "2025-10-07", "planned");
        Trip saved = new Trip("Lisbon Trip", "Lisbon", "2025-10-01", "2025-10-07", "planned");
        saved.setTripId(1L);
        when(tripRepository.save(input)).thenReturn(saved);

        var response = tripController.createTrip(input);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(1L, response.getBody().getTripId());
    }

    // Test 6: PUT /api/trips/{id} updates trip when it exists
    @Test
    void updateTrip_exists_returnsUpdatedTrip() {
        Trip existing = new Trip("Old Name", "Old City", "2025-01-01", "2025-01-05", "planned");
        Trip updates = new Trip("New Name", "New City", "2025-02-01", "2025-02-10", "completed");
        when(tripRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(tripRepository.save(any(Trip.class))).thenAnswer(i -> i.getArguments()[0]);

        var response = tripController.updateTrip(1L, updates);

        assertEquals(200, response.getStatusCode().value());
        assertEquals("New Name", response.getBody().getName());
        assertEquals("completed", response.getBody().getStatus());
    }

    // Test 7: PUT /api/trips/{id} returns 404 when trip does not exist
    @Test
    void updateTrip_notFound_returns404() {
        when(tripRepository.findById(99L)).thenReturn(Optional.empty());

        var response = tripController.updateTrip(99L, new Trip());

        assertEquals(404, response.getStatusCode().value());
    }

    // Test 8: DELETE /api/trips/{id} returns 204 when trip exists
    @Test
    void deleteTrip_exists_returns204() {
        when(tripRepository.existsById(1L)).thenReturn(true);

        var response = tripController.deleteTrip(1L);

        assertEquals(204, response.getStatusCode().value());
        verify(tripRepository).deleteById(1L);
    }

    // Test 9: DELETE /api/trips/{id} returns 404 when trip does not exist
    @Test
    void deleteTrip_notFound_returns404() {
        when(tripRepository.existsById(99L)).thenReturn(false);

        var response = tripController.deleteTrip(99L);

        assertEquals(404, response.getStatusCode().value());
        verify(tripRepository, never()).deleteById(any());
    }

    // Test 10: GET /api/trips returns empty list when no trips exist
    @Test
    void getAllTrips_noTrips_returnsEmptyList() {
        when(tripRepository.findAll()).thenReturn(List.of());

        List<Trip> result = tripController.getAllTrips(null);

        assertTrue(result.isEmpty());
    }
}
