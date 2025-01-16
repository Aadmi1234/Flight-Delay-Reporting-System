package flight.analysis.admin.controller;

import flight.analysis.admin.dto.BookFlightDTO;
import flight.analysis.admin.dto.CustomerDTO;
import flight.analysis.admin.dto.DelayDataDTO;
import flight.analysis.admin.model.Customer;
import flight.analysis.admin.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("register")
    ResponseEntity<String> registerCustomer(@RequestBody CustomerDTO customer) {
        return customerService.registerCustomer(customer);
    }

    @PostMapping("bookFlight/{flight}")
    ResponseEntity<String> bookFlight(@RequestBody BookFlightDTO bookFlightDTO) {
        return customerService.bookFlight(bookFlightDTO);
    }

    @GetMapping("getFlights")
    List<DelayDataDTO> getFlights(@RequestBody CustomerDTO customer) {
        return customerService.getFlights(customer);
    }

    @GetMapping("getFlight/{flight}")
    Optional<DelayDataDTO> getFlight(@RequestBody CustomerDTO customer, @PathVariable("flight") Long flight) {
        DelayDataDTO delay = customerService.getFlight(customer, flight);
        return Optional.ofNullable(delay);
    }
}
