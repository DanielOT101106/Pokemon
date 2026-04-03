package org.example;

import java.util.Scanner;
import java.util.Random;

import static java.lang.System.*;

public class Batalla {

    private EquipoPokemon equipo1;
    private EquipoPokemon equipo2;
    private Scanner scanner;
    private Pokemon pokemonActivo1;
    private Pokemon pokemonActivo2;

    public Batalla(EquipoPokemon equipo1, EquipoPokemon equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.scanner = new Scanner(in);
    }

    public void iniciar() {
        pokemonActivo1 = elegirPokemon(equipo1, null);
        pokemonActivo2 = elegirPokemon(equipo2, null);

        out.println("¡Comienza la batalla entre " + pokemonActivo1.getName() + " y " + pokemonActivo2.getName() + "!");

        while (!equipo1.allFainted() && !equipo2.allFainted()) {

            if (pokemonActivo1.getStats().getHealth() == 0) {

                pokemonActivo1 = elegirPokemon(equipo1, pokemonActivo1);
            } else if (pokemonActivo2.getStats().getHealth() == 0) {

                pokemonActivo2 = elegirPokemon(equipo2, pokemonActivo2);
            }
            turno(pokemonActivo1, pokemonActivo2);


        }

        if (equipo1.allFainted()) {
            out.println("\n¡Gana el equipo 2!");
        } else {
            out.println("\n¡Gana el equipo 1!");
        }
    }

    private Move elegirMovimiento(Pokemon pokemon) {
        out.println("Movimientos de " + pokemon.getName() + "(" + pokemon.getStats().getHealth() + "):");
        for (int i = 0; i < pokemon.getMoves().size(); i++) {
            out.println((i + 1) + ". " + pokemon.getMoves().get(i));
        }

        int opcion = -1;
        while (opcion < 1 || opcion > pokemon.getMoves().size()) {
            out.print("Elige un movimiento (1-" + pokemon.getMoves().size() + "): ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }
        }

        return pokemon.getMoves().get(opcion - 1);
    }

    private Pokemon elegirPokemon(EquipoPokemon equipoPokemonEjemplo, Pokemon pokemonActivo) {
        out.println("Select a pokemon:");

        for (int i = 0; i < equipoPokemonEjemplo.getPokemonTeam().size(); i++) {
            Pokemon p = equipoPokemonEjemplo.getPokemonTeam().get(i);
            String estado = (p.getStats().getHealth() > 0) ? "" : " (DEBILITADO)";
            out.println((i + 1) + ". " + p + estado);
        }

        int opcion = -1;
        while (true) {
            out.print("Elige un pokemon (1-" + equipoPokemonEjemplo.getPokemonTeam().size() + "): ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion >= 1 && opcion <= equipoPokemonEjemplo.getPokemonTeam().size()) {
                    Pokemon elegido = equipoPokemonEjemplo.getPokemonTeam().get(opcion - 1);

                    if (elegido.equals(pokemonActivo)) {
                        out.println("Ese Pokémon ya está en combate. Elige otro.");
                    } else if (elegido.getStats().getHealth() <= 0) {
                        out.println("Ese Pokémon está debilitado. Elige otro.");
                    } else {
                        return elegido;
                    }
                } else {
                    out.println("Opción fuera de rango.");
                }
            } catch (NumberFormatException e) {
                out.println("Entrada no válida. Introduce un número.");
            }
        }
    }




    public void turno(Pokemon pokemon1, Pokemon pokemon2) {

        Move move1 = null;
        Move move2 = null;
        Pokemon pokemon1AtFirst = pokemon1;
        Pokemon pokemon2AtFirst = pokemon2;

        int option1 = elegirAccion(pokemon1);

        if(option1 == 1) {
            move1 = elegirMovimiento(pokemon1);
        }else{
            pokemon1 = elegirPokemon(equipo1, pokemonActivo1);
        }

        int option2 = elegirAccion(pokemon2);

        if(option2 == 1) {
            move2 = elegirMovimiento(pokemon2);
        }else{
            pokemon2 = elegirPokemon(equipo2, pokemonActivo2);
        }

        if(option1 == 1 && option2 == 1) {

            CalculateSpeedToAttack(pokemon1, pokemon2, move1, move2);

        } else if (option1 == 1 && option2 == 2) {

            out.println(pokemon2AtFirst + " go out");
            out.println(pokemon2 + " go in");
            attack(pokemon1, pokemon2, move1);

        } else if (option1 == 2 && option2 == 1) {

            out.println(pokemon1AtFirst + " go out");
            out.println(pokemon1 + " go in");
            attack(pokemon2, pokemon1, move2);

        } else if (option1 == 2 && option2 == 2) {

            CalculateSpeedToChange(pokemon1, pokemon2, pokemon2AtFirst, pokemon1AtFirst);

        }
        pokemonActivo1 = pokemon1;
        pokemonActivo2 = pokemon2;

    }

    private static void CalculateSpeedToChange(Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon2AtFirst, Pokemon pokemon1AtFirst) {
        if (pokemon2.getStats().getSpeed() > pokemon1.getStats().getSpeed()) {
            out.println(pokemon2AtFirst + " go out");
            out.println(pokemon2 + " go in");
            out.println(pokemon1AtFirst + " go out");
            out.println(pokemon1 + " go in");
        }else{
            out.println(pokemon1AtFirst + " go out");
            out.println(pokemon1 + " go in");
            out.println(pokemon2AtFirst + " go out");
            out.println(pokemon2 + " go in");
        }
    }

    private void CalculateSpeedToAttack(Pokemon pokemon1, Pokemon pokemon2, Move move1, Move move2) {
        if (pokemon1.getStats().getSpeed() > pokemon2.getStats().getSpeed()) {

            attack(pokemon1, pokemon2, move1);
            if (pokemon2.getStats().getHealth() > 0) {
                attack(pokemon2, pokemon1, move2);
            }
        } else {
            attack(pokemon2, pokemon1, move2);
            if (pokemon1.getStats().getHealth() > 0) {
                attack(pokemon1, pokemon2, move1);
            }
        }
    }

    private void attack(Pokemon pokemonAttack, Pokemon pokemonDefense, Move move) {

        Random rand = new Random();
        int aleatorio = rand.nextInt(16) + 85;
        int damage = 0;

        if (move.isSpecial()) {
            int attack = pokemonAttack.getStats().getSpecialAttack();
            int defense = pokemonDefense.getStats().getSpecialDefense();
            damage = (int) (0.01 * aleatorio * (((0.2 * 50 + 1) * attack * move.getPower()) / (25 * defense) + 2));

        } else {
            int attack = pokemonAttack.getStats().getAttack();
            int defense = pokemonDefense.getStats().getDefense();
            damage = (int) (0.01 * aleatorio * (((0.2 * 50 + 1) * attack * move.getPower()) / (25 * defense) + 2));

        }
        if (damage > pokemonDefense.getStats().getHealth()) {
            pokemonDefense.getStats().setHealth(0);
            out.println(pokemonDefense.getName() + " fainted");
        } else {
            pokemonDefense.getStats().setHealth(pokemonDefense.getStats().getHealth() - damage);
            out.println(pokemonAttack.getName() + " Do " + damage + " points of damage to " + pokemonDefense.getName());
        }
    }

    private int elegirAccion(Pokemon pokemon) {
        out.println("Turno de " + pokemon.getName() + " (" + pokemon.getStats().getHealth() + " HP)");
        out.println("1. Atacar");
        out.println("2. Cambiar de Pokémon");

        int opcion = -1;
        while (opcion < 1 || opcion > 2) {
            out.print("Elige una acción (1-2): ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }
        }

        return opcion;

    }
}

