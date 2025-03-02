package bookMyShow.service;

import bookMyShow.model.Booking;
import bookMyShow.model.BookingStatus;
import bookMyShow.model.Seat;
import bookMyShow.model.Show;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BookingService {

    private Map<String, Booking> bookingsMap = new HashMap<>();
    private LockProvider lockProvider = new InMemoryLockProvider();

    public void createBooking(Show show, List<Seat> seats, String userId) throws Exception {

        if(anySeatsBooked(show,seats)){
            throw new Exception(); //Seat Permanently Unavailable Exception
        }

        lockProvider.lockSeats(show,seats,userId);

        Booking booking = new Booking(UUID.randomUUID().toString(), show,seats,userId);
        bookingsMap.put(booking.getBookingId(), booking);

    }

    public void confirmBooking(String bookingId) throws Exception {
        Booking booking = bookingsMap.get(bookingId);
        if(anySeatsBooked(booking.getShow(),booking.getSeats())){
            throw new Exception();//Seat Permanently Unavailable
        }

        if(lockProvider.validateLock(booking.getShow(),booking.getSeats(),booking.getUser())){
            throw new Exception(); //Lock has expired//Payment Reverse
        }

        booking.setBookingStatus(BookingStatus.CONFIRMED);
    }

    private boolean anySeatsBooked(Show show , List<Seat> seats){

        for(Booking booking : bookingsMap.values()){
            if(show.equals(booking.getShow()) && booking.getBookingStatus().equals(BookingStatus.CONFIRMED)){
                if(seats.stream().anyMatch(seat -> booking.getSeats().contains(seat))){
                    return true;
                }
            }
        }
        return false;
    }
}
