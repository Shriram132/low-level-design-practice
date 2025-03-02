package bookMyShow.model;


import java.util.List;

public class Screen {

    private String id;

    private String name;

    private Theatre theatre;

    List<Seat> seats;

    public Screen(String id , String name, Theatre theatre, List<Seat> seats){
        this.id = id;
        this.name = name;
        this.theatre = theatre;
        this.seats = seats;
    }



}
