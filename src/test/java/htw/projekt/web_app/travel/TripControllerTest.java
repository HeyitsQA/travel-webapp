package htw.projekt.web_app.travel;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;
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

    @Test
    void getAllTripsReturnsEmptyListInitially() {
        when(tripRepository.findAll()).thenReturn(List.of());
        assertTrue(tripController.getAllTrips().isEmpty());
    }

    @Test
    void getTripByIdReturnsNullWhenNotFound() {
        when(tripRepository.findById(99L)).thenReturn(Optional.empty());
        assertEquals(404, tripController.getTripById(99L).getStatusCode().value());
    }
}