package org.example;

public class Stats {
    private int health;
    private int attack;
    private int special_attack;
    private int defense;
    private int special_defense;
    private int speed;

    public Stats(int health, int attack, int special_attack, int defense, int special_defense, int speed) {
        this.health = health;
        this.attack = attack;
        this.special_attack = special_attack;
        this.defense = defense;
        this.special_defense = special_defense;

        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getSpecialAttack() {return special_attack;}

    public int getSpecialDefense() {
        return special_defense;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setHealth(int newHealth){ health = newHealth;}

    public void setAttack(int attack) {this.attack = attack;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stats stats = (Stats) o;

        return health == stats.health &&
                attack == stats.attack &&
                special_attack == stats.special_attack &&
                defense == stats.defense &&
                special_defense == stats.special_defense &&
                speed == stats.speed;
    }

    @Override
    public int hashCode() {
        int result = health;
        result = 31 * result + attack;
        result = 31 * result + special_attack;
        result = 31 * result + defense;
        result = 31 * result + special_defense;
        result = 31 * result + speed;
        return result;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "health=" + health +
                ", attack=" + attack +
                ", defense=" + defense +
                ", speed=" + speed +
                '}';
    }
}
