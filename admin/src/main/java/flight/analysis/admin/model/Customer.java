package flight.analysis.admin.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    String name;
    @Id
    String mobileNo;
}
