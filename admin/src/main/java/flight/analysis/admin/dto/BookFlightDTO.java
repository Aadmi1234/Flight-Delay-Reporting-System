package flight.analysis.admin.dto;

import flight.analysis.admin.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookFlightDTO {
    Customer customer;
    Long flight;
}