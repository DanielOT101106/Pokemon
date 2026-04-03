package org.example;

public class ChoiceSpecs implements Objeto {

    final private String nombre;
    private Move movimientoBloqueado;

    public ChoiceSpecs() {
        this.nombre = "ChoiceSpecs";
        this.movimientoBloqueado = null;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getAccion() {
        return "Aumenta el ataque especial x1.5 y bloquea al primer movimiento usado";
    }
    @Override
    public void aplicarEfecto(Pokemon pokemon) {
        int newSpecialAttack = (int) (pokemon.getStats().getSpecialAttack() * 1.5);
        pokemon.getStats().setSpeed(newSpecialAttack);
    }
    @Override
    public Move elegirMovimiento(Move movimiento) {
        if (movimientoBloqueado == null) {
            movimientoBloqueado = movimiento;
        }
        return movimientoBloqueado;
    }
}