package com.yalantis.watch;

/**
 * Created by Dmitriy Dovbnya on 08.09.2014.
 */
public class Model {

    private int id;

    private String name;

    private int color;

    public Model(int id, String name, int color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

}
