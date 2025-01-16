package flight.analysis.customer.feign;

import flight.analysis.customer.dto.BookFlightDTO;
import flight.analysis.customer.dto.CustomerDTO;
import flight.analysis.customer.dto.DelayDataDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "admin")
public interface AdminInterface {
    @PostMapping("customer/register")
    ResponseEntity<String> registerCustomer(@RequestBody CustomerDTO customer);

    @PostMapping("customer/bookFlight")
    ResponseEntity<String> bookFlight(@RequestBody BookFlightDTO bookFlightDTO);

    @GetMapping("customer/getFlights")
    List<DelayDataDTO> getFlights(@RequestBody CustomerDTO customer);

    @GetMapping("customer/getFlight/{flight}")
    Optional<DelayDataDTO> getFlight(@RequestBody CustomerDTO customer, @PathVariable("flight") Long flight);
}
