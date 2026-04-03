package org.example;

import java.util.Objects;

public class Move {
    private String name;
    private String type;
    private int power;
    private int accurate;
    private boolean attack;

    public Move(String name, String type, int power, int accurate, boolean attack) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.accurate = accurate;
        this.attack = attack;
    }




    public String getName(){return name;}

    public String getType(){return type;}

    public int getPower(){return power;}

    public int getAccurate(){return accurate;}

    public boolean isSpecial(){return attack;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Move)) return false;
        Move move = (Move) o;
        return power == move.power &&
                accurate == move.accurate &&
                attack == move.attack &&
                Objects.equals(name, move.name) &&
                Objects.equals(type, move.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, power, accurate, attack);
    }

    @Override
    public String toString() {
        return name + " (" + type + ", " + power + " power, " + accurate + "%)";
    }


}
