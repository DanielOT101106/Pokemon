package org.example.Objetoss;

import org.example.Move;
import org.example.Pokemon;

public interface Objeto {

    String getNombre();

    String getAccion();

    void aplicarEfecto(Pokemon pokemon);

    Move elegirMovimiento(Move move);

}
