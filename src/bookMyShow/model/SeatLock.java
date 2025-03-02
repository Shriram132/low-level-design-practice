package bookMyShow.model;


import java.sql.Timestamp;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeatLock {

    private Seat seat;

    private String userId;

    private Date lockEndTime;

    public SeatLock(Seat seat, String userId) {
        this.seat = seat;
        this.userId = userId;
        this.lockEndTime = new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5));
    }

    public String getUserId() {
        return userId;
    }

    public boolean isExpired(){
        return this.lockEndTime.before(new Date());
    }
}
