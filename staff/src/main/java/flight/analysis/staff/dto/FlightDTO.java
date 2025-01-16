package flight.analysis.staff.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightDTO {
    Long number;
    String source;
    String destination;
    Long tof;
    Long delay;
}
