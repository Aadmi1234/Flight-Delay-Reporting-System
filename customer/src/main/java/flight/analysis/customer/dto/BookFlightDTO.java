package flight.analysis.customer.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BookFlightDTO {
    CustomerDTO customer;
    String flight;
}