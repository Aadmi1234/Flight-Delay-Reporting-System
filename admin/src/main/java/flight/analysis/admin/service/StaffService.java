package flight.analysis.admin.service;

import flight.analysis.admin.model.Flight;
import flight.analysis.admin.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffService {
    @Autowired
    private FlightRepo flightRepo;

    public ResponseEntity<String> addFlight(Flight flight) {
        Optional<Flight> temp = flightRepo.findById(flight.getNumber());
        if (temp.isEmpty()) {
            flightRepo.save(flight);
            return new ResponseEntity<>("Flight added.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Flight already present.", HttpStatus.CONFLICT);
    }

    public ResponseEntity<String> updateFlight(Flight flight, Long flightId) {
        Optional<Flight> temp = flightRepo.findById(flight.getNumber());
        if (temp.isEmpty()) {
            flightRepo.save(flight);
            return new ResponseEntity<>("Flight updated.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Flight not present.", HttpStatus.BAD_REQUEST);
    }
}
