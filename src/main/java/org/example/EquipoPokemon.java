package org.example;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class EquipoPokemon {

    private List<Pokemon> equipo;

    // Constructor: crea un equipo vacío
    public EquipoPokemon(List<Pokemon> equipo) {
        this.equipo = equipo;
    }

    // Método para devolver la lista de Pokémon
    public List<Pokemon> getPokemonTeam() {
        return equipo;
    }

    // Método para añadir un Pokémon (opcional)
    public void addPokemon(Pokemon p) {
        if (equipo.size() < 6) {
            equipo.add(p);
        } else {
            throw new IllegalStateException("El equipo ya tiene 6 Pokémon.");
        }
    }
public boolean allFainted(){

        boolean allFainted = true;

    for (Pokemon pokemon : equipo) {
        if (pokemon.getStats().getHealth() != 0) {
            allFainted = false;
            break;
        }
    }
     return allFainted;
}



    @Override
    public String toString() {
        if (equipo.isEmpty()) {
            return "Equipo vacío.";
        }

        StringBuilder sb = new StringBuilder("Equipo Pokémon:\n");

        for (int i = 0; i < equipo.size(); i++) {
            Pokemon p = equipo.get(i);
            sb.append((i + 1)).append(". ")
                    .append(p.getName())
                    .append(" [").append(p.getType()).append("] ")
                    .append(" - HP: ").append(p.getStats().getHealth())
                    .append(" - Movimientos: ");

            for (int j = 0; j < p.getMoves().size(); j++) {
                sb.append(p.getMoves().get(j).getName());
                if (j < p.getMoves().size() - 1) sb.append(", ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }

}

