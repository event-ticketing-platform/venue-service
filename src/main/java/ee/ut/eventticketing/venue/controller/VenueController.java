package ee.ut.eventticketing.venue.controller;

import ee.ut.eventticketing.venue.dto.VenueRequest;
import ee.ut.eventticketing.venue.dto.VenueResponse;
import ee.ut.eventticketing.venue.service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venues")
public class VenueController {

    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VenueResponse createVenue(@RequestBody VenueRequest request) {
        return venueService.createVenue(request);
    }

    @GetMapping
    public List<VenueResponse> getAllVenues() {
        return venueService.getAllVenues();
    }

    @GetMapping("/{id}")
    public VenueResponse getVenueById(@PathVariable Long id) {
        return venueService.getVenueById(id);
    }

    @PutMapping("/{id}")
    public VenueResponse updateVenue(
            @PathVariable Long id,
            @RequestBody VenueRequest request
    ) {
        return venueService.updateVenue(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVenue(@PathVariable Long id) {
        venueService.deleteVenue(id);
    }
}