package flight.analysis.admin.repository;

import flight.analysis.admin.model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingsRepo extends JpaRepository<Bookings, Long> {
    List<Bookings> findByMobileNo(String mobileNo);

    Optional<Bookings> findOneByMobileNoAndFlight(String mobileNo, Long flight);
}
