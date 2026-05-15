package htw.projekt.web_app.travel.model;

import java.time.LocalDate;

public class Trip {
     private long id;
    @NotBlank
     private String name;
     private String status;
    @NotNull
     private String startDate;
    @NotNull
     private String endDate;
    private String description;

    public Trip(long id, String name, String status, String startDate, String endDate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getDescription() {
        return description;
    }
}
