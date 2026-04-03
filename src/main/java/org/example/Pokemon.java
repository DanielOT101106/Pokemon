package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    private String type, name;
    private List<Move> moves;
    private Stats stats;
    private Objeto objeto;

    public Pokemon(String name, Stats stats, String type, List<Move> moves, Objeto objeto){

        this.moves = new ArrayList<>(moves);
        this.stats = stats;
        this.type = type;
        this.name = name;
        this.objeto = objeto;

    }

    public Stats getStats(){return stats;}

    public String getType(){return type;}

    public List<Move> getMoves(){return moves;}

    public String getName() {return name;}

    public Objeto getObjeto() {return objeto;}

    public void addOrReplaceMove(Move move, int replaceIndex) {
        // Comprobamos si ya tiene un movimiento con el mismo nombre
        for (Move m : moves) {
            if (m.getName().equalsIgnoreCase(move.getName())) {
                throw new IllegalArgumentException("Este movimiento ya está asignado al Pokémon.");
            }
        }

        if (moves.size() < 4) {
            moves.add(move);
        } else {
            if (replaceIndex >= 0 && replaceIndex < 4) {
                moves.set(replaceIndex, move);
            } else {
                throw new IllegalArgumentException("El índice debe estar entre 0 y 3 para reemplazar un movimiento.");
            }
        }
    }

    public void efectuarMetodoObjeto(){
        objeto.aplicarEfecto(this);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pokemon pokemon = (Pokemon) o;

        if (!name.equals(pokemon.name)) return false;
        if (!type.equals(pokemon.type)) return false;
        if (!stats.equals(pokemon.stats)) return false;
        return moves.equals(pokemon.moves);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + stats.hashCode();
        result = 31 * result + moves.hashCode();
        return result;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name)
                .append(" [").append(type).append("] - ")
                .append("HP: ").append(stats.getHealth())
                .append(" - Movimientos: ");
        for (int i = 0; i < moves.size(); i++) {
            sb.append(moves.get(i).getName());
            if (i < moves.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }




}
