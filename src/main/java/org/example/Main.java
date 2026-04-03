package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear movimientos
        Move tackle = new Move("Tackle", "Normal", 40, 100, false);
        Move ember = new Move("Ember", "Fire", 40, 100, true);
        Move waterGun = new Move("Water Gun", "Water", 40, 100, true);
        Move vineWhip = new Move("Vine Whip", "Grass", 45, 100, false);

        // Crear Pokémon con constructor (name, stats, type, moves)
        Stats stats1 = new Stats(100, 50, 40, 60, 50, 65);
        List<Move> moves1 = List.of(tackle, ember);
        Pokemon charmander = new Pokemon("Charmander", stats1, "Fire", moves1);

        Stats stats2 = new Stats(110, 48, 50, 60, 65, 43);
        List<Move> moves2 = List.of(tackle, waterGun);
        Pokemon squirtle = new Pokemon("Squirtle", stats2, "Water", moves2);

        Stats stats3 = new Stats(105, 52, 49, 60, 65, 45);
        List<Move> moves3 = List.of(tackle, vineWhip);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", stats3, "Grass", moves3);

        // Crear equipos
        List<Pokemon> team1 = new ArrayList<>();
        team1.add(charmander);
        team1.add(bulbasaur);

        List<Pokemon> team2 = new ArrayList<>();
        team2.add(squirtle);

        EquipoPokemon equipo1 = new EquipoPokemon(team1);
        EquipoPokemon equipo2 = new EquipoPokemon(team2);

        // Iniciar batalla
        Batalla batalla = new Batalla(equipo1, equipo2);
        batalla.iniciar();
    }
}
