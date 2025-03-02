package bookMyShow.service;

import bookMyShow.model.Seat;
import bookMyShow.model.Show;

import java.util.List;

public interface LockProvider {

     void lockSeats(Show show, List<Seat> seats, String userId) throws Exception;

    boolean validateLock(Show show, List<Seat> seats, String user);
}
