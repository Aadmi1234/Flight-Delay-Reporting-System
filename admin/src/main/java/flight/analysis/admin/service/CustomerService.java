package flight.analysis.admin.service;

import flight.analysis.admin.dto.BookFlightDTO;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private BookingsRepo bookingsRepo;

    @Autowired
    private FlightRepo flightRepo;

    public ResponseEntity<String> registerCustomer(Customer customer) {
        Optional<Customer> temp = customerRepo.findById(customer.getId());
        if (temp.isEmpty()) {
            customerRepo.save(customer);
            return new ResponseEntity<>("Customer added.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Customer already present.", HttpStatus.CONFLICT);
    }

    public ResponseEntity<String> bookFlight(BookFlightDTO bookFlightDTO) {
        Optional<Flight> flight = flightRepo.findById(bookFlightDTO.getFlight());
        if (!flight.isEmpty()) {
            Bookings booking = new Bookings();
            booking.setCustomerId(bookFlightDTO.getCustomer().getId());
            booking.setFlight(flight.get().getNumber());
            bookingsRepo.save(booking);
            return new ResponseEntity<>("Flight booked.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Flight not found.", HttpStatus.NOT_FOUND);
    }

    public List<DelayDataDTO> getFlights(Customer customer) {
        Long customerId = customer.getId();
        List<Bookings> bookings = bookingsRepo.findByCustomer(customerId);
        List<DelayDataDTO> delays = new ArrayList<>();
        if (!bookings.isEmpty()) delays = getDelays(bookings);
        return delays;
    }

    public DelayDataDTO getFlight(Customer customer, Long flight) {
        Long customerId = customer.getId();
        Optional<Bookings> booking = bookingsRepo.findFirstByCustomerAndFlight(customerId, flight);
        if (!booking.isEmpty()) return getDelays(Collections.singletonList(booking.get())).getFirst();
        return null;
    }

    private List<DelayDataDTO> getDelays(List<Bookings> bookings) {
        List<DelayDataDTO> delays = new ArrayList<>();
        for (Bookings booking : bookings) {
            Flight flight = flightRepo.findById(booking.getFlight()).get();
            DelayDataDTO temp = new DelayDataDTO(flight.getNumber(), flight.getDelay());
            delays.add(temp);
        }
        return delays;
    }
}
