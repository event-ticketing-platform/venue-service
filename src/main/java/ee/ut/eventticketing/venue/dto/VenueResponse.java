package ee.ut.eventticketing.venue.dto;

public class VenueResponse {

    private Long id;
    private String name;
    private String location;
    private Integer capacity;

    public VenueResponse() {
    }

    public VenueResponse(Long id, String name, String location, Integer capacity) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public VenueResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public VenueResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public VenueResponse setLocation(String location) {
        this.location = location;
        return this;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public VenueResponse setCapacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }
}