package flight.analysis.admin.repository;

import flight.analysis.admin.dto.DelayDataDTO;
import flight.analysis.admin.model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingsRepo extends JpaRepository<Bookings, Long> {
    List<Bookings> findByCustomer(Long customerId);

    Optional<Bookings> findFirstByCustomerAndFlight(Long customerId, Long flight);
}
