package flight.analysis.customer.controller;

import flight.analysis.customer.dto.BookFlightDTO;
import flight.analysis.customer.dto.CustomerDTO;
import flight.analysis.customer.dto.DelayDataDTO;
import flight.analysis.customer.feign.AdminInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    private AdminInterface adminInterface;

    @PostMapping("/register")
    ResponseEntity<String> registerCustomer(@RequestBody CustomerDTO customer) {
        return adminInterface.registerCustomer(customer);
    }

    @PostMapping("/bookFlight/{flight}")
    ResponseEntity<String> bookFlight(@RequestBody BookFlightDTO bookFlightDTO) {
        return adminInterface.bookFlight(bookFlightDTO);
    }

    @GetMapping("/getFlights")
    List<DelayDataDTO> getFlights(@RequestBody CustomerDTO customer) {
        return adminInterface.getFlights(customer);
    }

    @GetMapping("/getFlight/{flight}")
    Optional<DelayDataDTO> getFlight(@RequestBody CustomerDTO customer, @PathVariable("flight") Long flight) {
        return adminInterface.getFlight(customer, flight);
    }
}
