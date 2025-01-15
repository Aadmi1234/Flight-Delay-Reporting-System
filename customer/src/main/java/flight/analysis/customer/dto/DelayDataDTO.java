package flight.analysis.customer.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class DelayDataDTO {
    String flight;
    Long delay;
}