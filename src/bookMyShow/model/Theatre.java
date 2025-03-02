package bookMyShow.model;

import java.util.List;


public class Theatre {

    private String id;
    private List<Screen> screens;

    private String name;

    public Theatre (String id , List<Screen> screens , String name){
        this.id = id;
        this.name = name;
        this.screens = screens;
    }



}
