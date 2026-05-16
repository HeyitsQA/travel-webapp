package htw.projekt.web_app.travel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TripControllerTest {

    @Test
    void getAllTripsReturnsEmptyListInitially() {
        TripController controller = new TripController();
        assertTrue(controller.getAllTrips().isEmpty());
    }

    @Test
    void getTripByIdReturnsNullWhenNotFound() {
        TripController controller = new TripController();
        assertNull(controller.getTripById(99L));
    }
}