package bookMyShow.model;


import java.util.List;

public class Booking {

    private String bookingId;

    private Show show;

    List<Seat> seats;

    private String user;
    private BookingStatus bookingStatus;

    public Booking(String bookingId, Show show, List<Seat> seats, String user) {
        this.bookingId = bookingId;
        this.show = show;
        this.seats = seats;
        this.user = user;
        this.bookingStatus = BookingStatus.INITIATED;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
