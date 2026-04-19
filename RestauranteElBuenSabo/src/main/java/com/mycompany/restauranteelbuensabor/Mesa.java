package com.mycompany.restauranteelbuensabor;

public class Mesa {
    private int numeroMesa;
    private boolean estaActiva;

    public Mesa() {
        this.numeroMesa = 0;
        this.estaActiva = false;
    }

    public void activar(int numero) {
        this.numeroMesa = (numero > 0) ? numero : 1;
        this.estaActiva = true;
    }

    public void reiniciar() {
        this.numeroMesa = 0;
        this.estaActiva = false;
    }

    public boolean estaActiva() {
        return estaActiva;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }
}
