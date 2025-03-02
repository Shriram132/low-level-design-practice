package bookMyShow.model;


public class Show {

    private String id;

    private Movie movie;

    private Screen screen;

    private String duration;

    private String startTime;

    public Show(String id, Movie movie, Screen screen, String duration, String startTime) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.duration = duration;
        this.startTime = startTime;
    }
}
