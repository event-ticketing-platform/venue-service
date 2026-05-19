package ee.ut.eventticketing.venue.service;

import ee.ut.eventticketing.venue.dto.VenueRequest;
import ee.ut.eventticketing.venue.dto.VenueResponse;
import ee.ut.eventticketing.venue.model.Venue;
import ee.ut.eventticketing.venue.repository.VenueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VenueService {

    private final VenueRepository venueRepository;

    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public VenueResponse createVenue(VenueRequest request) {
        Venue venue = new Venue();

        venue.setName(request.getName());
        venue.setLocation(request.getLocation());
        venue.setCapacity(request.getCapacity());

        Venue savedVenue = venueRepository.save(venue);

        return toResponse(savedVenue);
    }

    public List<VenueResponse> getAllVenues() {
        return venueRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public VenueResponse getVenueById(Long id) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Venue not found"
                ));

        return toResponse(venue);
    }

    public VenueResponse updateVenue(Long id, VenueRequest request) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Venue not found"
                ));

        venue.setName(request.getName());
        venue.setLocation(request.getLocation());
        venue.setCapacity(request.getCapacity());

        Venue savedVenue = venueRepository.save(venue);

        return toResponse(savedVenue);
    }

    public void deleteVenue(Long id) {
        if (!venueRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Venue not found"
            );
        }

        venueRepository.deleteById(id);
    }

    private VenueResponse toResponse(Venue venue) {
        return new VenueResponse(
                venue.getId(),
                venue.getName(),
                venue.getLocation(),
                venue.getCapacity()
        );
    }
}