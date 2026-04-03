package org.example;


public class ChoiceBand implements Objeto {

    final private String nombre;
    private Move movimientoBloqueado;

    public ChoiceBand() {
        this.nombre = "ChoiceBand";
        this.movimientoBloqueado = null;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getAccion() {
        return "Aumenta el ataque x1.5 y bloquea al primer movimiento usado";
    }
    @Override
    public void aplicarEfecto(Pokemon pokemon) {
        int newAttack = (int) (pokemon.getStats().getAttack() * 1.5);
        pokemon.getStats().setAttack(newAttack);
    }
    @Override
    public Move elegirMovimiento(Move movimiento) {
        if (movimientoBloqueado == null) {
            movimientoBloqueado = movimiento;
        }
        return movimientoBloqueado;
    }
}