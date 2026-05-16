package htw.projekt.web_app.travel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TripTest {

    @Test
    void tripFieldsAreSetCorrectly() {
        Trip trip = new Trip(1L, "Paris Trip", "planned", "2026-06-01", "2026-06-10");

        assertEquals(1L, trip.getId());
        assertEquals("Paris Trip", trip.getName());
        assertEquals("planned", trip.getStatus());
        assertEquals("2026-06-01", trip.getStartDate());
        assertEquals("2026-06-10", trip.getEndDate());
    }

    @Test
    void tripSettersUpdateFieldsCorrectly() {
        Trip trip = new Trip(1L, "Paris Trip", "planned", "2026-06-01", "2026-06-10");

        trip.setName("Rome Trip");
        trip.setStatus("completed");

        assertEquals("Rome Trip", trip.getName());
        assertEquals("completed", trip.getStatus());
    }
}