package flight.analysis.admin.service;

import flight.analysis.admin.dto.FlightDTO;
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

    public ResponseEntity<String> addFlight(FlightDTO flight) {
        Optional<Flight> temp = flightRepo.findById(flight.getNumber());
        if (temp.isEmpty()) {
            Flight flight1 = temp.get();
            flight1.setDelay(flight.getDelay());
            flight1.setTof(flight.getTof());
            flight1.setDestination(flight.getDestination());
            flight1.setSource(flight.getSource());
            flightRepo.save(flight1);
            return new ResponseEntity<>("Flight added.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Flight already present.", HttpStatus.CONFLICT);
    }

    public ResponseEntity<String> updateFlight(FlightDTO flight, Long flightId) {
        Optional<Flight> temp = flightRepo.findById(flight.getNumber());
        if (temp.isEmpty()) {
            Flight flight1 = temp.get();
            flight1.setDelay(flight.getDelay());
            flight1.setTof(flight.getTof());
            flight1.setDestination(flight.getDestination());
            flight1.setSource(flight.getSource());
            flightRepo.save(flight1);
            return new ResponseEntity<>("Flight updated.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Flight not present.", HttpStatus.BAD_REQUEST);
    }
}
