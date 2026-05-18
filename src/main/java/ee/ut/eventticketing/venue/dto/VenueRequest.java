package ee.ut.eventticketing.venue.dto;

public class VenueRequest {

    private String name;
    private String location;
    private Integer capacity;

    public VenueRequest() {
    }

    public VenueRequest(String name, String location, Integer capacity) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public VenueRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public VenueRequest setLocation(String location) {
        this.location = location;
        return this;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public VenueRequest setCapacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }
}