/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Proceso {

    public static double calcularSubtotal() {
        double subtotal = 0;
        int indice = 0;
        while (indice < Datos.nombres.length) {
            if (Datos.cantidades[indice] > 0) {
                subtotal = subtotal + Datos.precios[indice] * Datos.cantidades[indice];
            }
            indice++;
        }
        return subtotal;
    }

    public static int contarItems() {
        int contadorItems = 0;
        int indice = 0;
        while (indice < Datos.cantidades.length) {
            if (Datos.cantidades[indice] > 0) {
                contadorItems = contadorItems + 1;
            }
            indice++;
        }
        return contadorItems;
    }

    public static double aplicarDescuento(double subtotal) {
        if (contarItems() > Configuracion.MIN_ITEMS_DESCUENTO) {
            return subtotal - (subtotal * Configuracion.TASA_DESCUENTO);
        }
        return subtotal;
    }

    public static double calcularIVA(double base) {
        return base * Configuracion.TASA_IVA;
    }

    public static double calcularPropina(double base) {
        if (base > Configuracion.UMBRAL_PROPINA) {
            return (base + calcularIVA(base)) * Configuracion.TASA_PROPINA;
        }
        return 0;
    }

    public static double calcularTotalFactura() {
        double subtotal = calcularSubtotal();
        double subtotalConDescuento = aplicarDescuento(subtotal);
        double montoIva = calcularIVA(subtotalConDescuento);
        double montoPropina = calcularPropina(subtotalConDescuento);
        double total = subtotalConDescuento + montoIva + montoPropina;

        Datos.estadoMesa = 1;
        Datos.totalActual = total;
        return total;
    }

}
