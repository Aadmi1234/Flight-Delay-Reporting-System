package flight.analysis.admin.controller;

import flight.analysis.admin.dto.FlightDTO;
import flight.analysis.admin.model.Flight;
import flight.analysis.admin.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("addFlight")
    ResponseEntity<String> addFlight(@RequestBody FlightDTO flight) {
        return staffService.addFlight(flight);
    }

    @PostMapping("updateFlight/{flight}")
    ResponseEntity<String> updateFlight(@RequestBody FlightDTO flight, @PathVariable Long flightId) {
        return staffService.updateFlight(flight, flightId);
    }
}
