package org.example;

public class ChoiceScarf implements Objeto {

    final private String nombre;
    private Move movimientoBloqueado;

    public ChoiceScarf() {
        this.nombre = "ChoiceScarf";
        this.movimientoBloqueado = null;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getAccion() {
        return "Aumenta la velocidad x1.5 y bloquea al primer movimiento usado";
    }
    @Override
    public void aplicarEfecto(Pokemon pokemon) {
        int newSpeed = (int) (pokemon.getStats().getSpeed() * 1.5);
        pokemon.getStats().setSpeed(newSpeed);
    }
    @Override
    public Move elegirMovimiento(Move movimiento) {
        if (movimientoBloqueado == null) {
            movimientoBloqueado = movimiento;
        }
        return movimientoBloqueado;
    }
}
