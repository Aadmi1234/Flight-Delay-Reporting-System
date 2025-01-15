package flight.analysis.staff.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {
    Long number;
    String source;
    String destination;
    Long tof;
    Long delay;
}
