package com.mycompany.restauranteelbuensabor;

public class Factura {
    private final Pedido pedido;
    private final int numero;

    public Factura(Pedido pedido, int numero) {
        this.pedido = pedido;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public double calcularSubtotal() {
        return pedido.calcularSubtotal();
    }

    public double calcularDescuento() {
        if (pedido.contarItemsDiferentes() > Configuracion.MIN_ITEMS_DESCUENTO) {
            return calcularSubtotal() * Configuracion.TASA_DESCUENTO;
        }
        return 0;
    }

    public double calcularSubtotalConDescuento() {
        return calcularSubtotal() - calcularDescuento();
    }

    public double calcularIVA() {
        // El IVA se calcula sobre el subtotal ya descontado, segun DIAN 2024
        return calcularSubtotalConDescuento() * Configuracion.TASA_IVA;
    }

    public double calcularPropina() {
        // La propina aplica sobre el total con IVA incluido, no sobre el subtotal
        if (calcularSubtotalConDescuento() > Configuracion.UMBRAL_PROPINA) {
            return (calcularSubtotalConDescuento() + calcularIVA()) * Configuracion.TASA_PROPINA;
        }
        return 0;
    }

    public double calcularTotal() {
        return calcularSubtotalConDescuento() + calcularIVA() + calcularPropina();
    }
}
