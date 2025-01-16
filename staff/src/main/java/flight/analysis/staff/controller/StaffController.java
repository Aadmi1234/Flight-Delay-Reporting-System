package flight.analysis.staff.controller;

import flight.analysis.staff.dto.FlightDTO;
import flight.analysis.staff.feign.AdminInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {
    @Autowired
    private AdminInterface adminInterface;

    @PostMapping("addFlight")
    ResponseEntity<String> addFlight(@RequestBody FlightDTO flightDTO) {
        return adminInterface.addFlight(flightDTO);
    }

    @PostMapping("/updateFlight")
    ResponseEntity<String> updateFlight(@RequestBody FlightDTO flightDTO) {
        return adminInterface.updateFlight(flightDTO);
    }
}
