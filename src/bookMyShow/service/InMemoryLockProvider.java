package bookMyShow.service;

import bookMyShow.model.Seat;
import bookMyShow.model.SeatLock;
import bookMyShow.model.Show;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryLockProvider implements LockProvider{

    private Map<Show, Map<Seat, SeatLock>> lockedSeats = new HashMap<>();

    @Override
    public void  lockSeats(Show show, List<Seat> seats, String userId) throws Exception {

        if(anySeatsLocked(show,seats)){
            throw new Exception() ; // new Seat Temporarily Unavailable Exception
        }
        seats.forEach(
                seat -> {
                    Map<Seat,SeatLock> showMap = lockedSeats.getOrDefault(show,new HashMap<>());
                    showMap.put(seat,new SeatLock(seat,userId));
                    lockedSeats.put(show, showMap);
                });
    }

    @Override
    public boolean validateLock(Show show, List<Seat> seats, String user){
        return seats.stream().allMatch(
                seat-> validateSeatLock(show,seat,user));
    }

    private boolean anySeatsLocked(Show show ,List<Seat> seats){
        return seats.stream().anyMatch(seat-> isSeatLocked(show,seat));
    }

    private boolean isSeatLocked(Show show, Seat seat) {
        return lockedSeats.containsKey(show) && lockedSeats.get(show).containsKey(seat) && !lockedSeats.get(show).get(seat).isExpired();
    }

    private boolean validateSeatLock(Show show, Seat seat, String userId) {
        return lockedSeats.containsKey(show) && lockedSeats.get(show).containsKey(seat) &&
                !lockedSeats.get(show).get(seat).isExpired() && lockedSeats.get(show).get(seat).getUserId().equals(userId);
    }
}
