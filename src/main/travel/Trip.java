package htw.projekt.web_app.travel.model;

import java.time.LocalDate;

public class Trip {
     private long tripID;
     private String destinationName;
     private String address;
     private String description;
     private boolean visited;
     private LocalDate tripDate;

    public Trip() {
    }


    public Trip(long tripID, String destinationName, String address, String description, boolean visited, LocalDate tripDate) {
        this.tripID = tripID;
        this.destinationName = destinationName;
        this.address = address;
        this.description = description;
        this.visited = visited;
        this.tripDate = tripDate;
    }

    public long getTripID() {
        return tripID;
    }

    public void setTripID(long tripID) {
        this.tripID = tripID;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public LocalDate getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDate tripDate) {
        this.tripDate = tripDate;
    }
}
