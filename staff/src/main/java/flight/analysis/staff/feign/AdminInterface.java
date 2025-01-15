package flight.analysis.staff.feign;

import flight.analysis.staff.dto.FlightDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "admin")
public interface AdminInterface {
    @PostMapping("staff/addFlight")
    ResponseEntity<String> addFlight(@RequestBody FlightDTO flightDTO);

    @PostMapping("staff/updateFlight/{flight}")
    ResponseEntity<String> updateFlight(@RequestBody FlightDTO flightDTO, @PathVariable Long flight);
}
