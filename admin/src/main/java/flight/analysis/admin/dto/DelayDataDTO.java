package flight.analysis.admin.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class DelayDataDTO {
    Long flight;
    Long delay;
}