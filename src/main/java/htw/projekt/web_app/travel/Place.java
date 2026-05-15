public class Place {
    private Long placeId;
    private Long id;     // which trip it belongs to
    private String name;
    private String category; // "restaurant", "sight", "cafe"
    private String status;   // "visited" or "planned"
    private String notes;
    private Double rating;

    public Place( long placeId, long id, String name, String category, String status, String notes, String rating){
        this.placeId = placeId;
        this.id = id;
        this.name = name;
        this.category = category;
        this.status = status;
        this.notes = notes;
        this.rating = Double.parseDouble(rating);
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}

