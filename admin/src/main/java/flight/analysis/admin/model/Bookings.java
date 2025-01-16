package flight.analysis.admin.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bookings")
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long bookingId;
    String mobileNo;
    Long flight;
}
