package flight.analysis.admin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "flight")
public class Flight {
    @Id
    Long number;
    String source;
    String destination;
    Long tof;
    Long delay;
}
