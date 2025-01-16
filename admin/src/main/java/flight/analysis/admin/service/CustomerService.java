package flight.analysis.admin.service;

import flight.analysis.admin.dto.BookFlightDTO;
import flight.analysis.admin.dto.CustomerDTO;
import flight.analysis.admin.dto.DelayDataDTO;
import flight.analysis.admin.model.Bookings;
import flight.analysis.admin.model.Customer;
import flight.analysis.admin.model.Flight;
import flight.analysis.admin.repository.BookingsRepo;
import flight.analysis.admin.repository.CustomerRepo;
import flight.analysis.admin.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private BookingsRepo bookingsRepo;

    @Autowired
    private FlightRepo flightRepo;

    public ResponseEntity<String> registerCustomer(CustomerDTO customer) {
        Customer customer1 = new Customer();
        customer1.setName(customer.getName());
        customer1.setMobileNo(customer.getMobileNo());
        customerRepo.save(customer1);
        return new ResponseEntity<>("Customer added.", HttpStatus.OK);
    }

    public ResponseEntity<String> bookFlight(BookFlightDTO bookFlightDTO) {
        Optional<Flight> flight = flightRepo.findById(bookFlightDTO.getFlight());
        if (!flight.isEmpty()) {
            Bookings booking = new Bookings();
            booking.setMobileNo(bookFlightDTO.getCustomer().getMobileNo());
            booking.setFlight(flight.get().getNumber());
            bookingsRepo.save(booking);
            return new ResponseEntity<>("Flight booked.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Flight not found.", HttpStatus.NOT_FOUND);
    }

    public List<DelayDataDTO> getFlights(CustomerDTO customer) {
        String mobileNo = customer.getMobileNo();
        List<Bookings> bookings = bookingsRepo.findByMobileNo(mobileNo);
        List<DelayDataDTO> delays = new ArrayList<>();
        if (!bookings.isEmpty()) delays = getDelays(bookings);
        return delays;
    }

    public DelayDataDTO getFlight(CustomerDTO customer, Long flight) {
        String mobileNo = customer.getMobileNo();
        Optional<Bookings> booking = bookingsRepo.findOneByMobileNoAndFlight(mobileNo, flight);
        if (!booking.isEmpty()) return getDelays(Collections.singletonList(booking.get())).get(0);
        return null;
    }

    private List<DelayDataDTO> getDelays(List<Bookings> bookings) {
        List<DelayDataDTO> delays = new ArrayList<>();
        for (Bookings booking : bookings) {
            Flight flight = flightRepo.findById(booking.getFlight()).get();
            DelayDataDTO temp = new DelayDataDTO();
            temp.setDelay(flight.getDelay());
            temp.setFlight(flight.getNumber());
            delays.add(temp);
        }
        return delays;
    }
}
