package org.example;

public interface Objeto {

    String getNombre();

    String getAccion();

    void aplicarEfecto(Pokemon pokemon);

    Move elegirMovimiento(Move move);

}
