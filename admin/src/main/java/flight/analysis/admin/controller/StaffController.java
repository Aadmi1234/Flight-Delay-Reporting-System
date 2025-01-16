package flight.analysis.admin.controller;

import flight.analysis.admin.dto.FlightDTO;
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
    ResponseEntity<String> addFlight(@RequestBody FlightDTO flightDTO) {
        return staffService.addFlight(flightDTO);
    }

    @PostMapping("updateFlight/{flight}")
    ResponseEntity<String> updateFlight(@RequestBody FlightDTO flight) {
        return staffService.updateFlight(flight);
    }
}
