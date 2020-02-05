package models;

import java.util.ArrayList;

public class Clase {

    private long id;
    private String name;
    private String nickname;
    private String city;
    private String conference;
    private boolean nbaClase;

    public String getName(){
        return name;
    }

    public long getId(){
        return id;
    }

    private ArrayList<Algo> algoList;

    public Clase(long id, String name, String nickname, String city, String conference, boolean nbaClase){
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.city = city;
        this.conference = conference;
        this.nbaClase = nbaClase;
        this.algoList = new ArrayList<>();
    }

    public Object[] toObjectArray(){
        return new Object[]{this.id, this.name, this.nickname, this.city, this.conference, this.nbaClase};
    }

}