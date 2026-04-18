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

    public static double calcularTotalFactura() {
        double subtotal = 0;
        double montoIva = 0;
        double total = 0;
        double subtotalConDescuento = 0;
        int contadorItems = 0;
        int indice = 0;
        while (indice < Datos.nombre.length) {
            if (Datos.cantidades[indice] > 0) {
// multiplica precio por cantidad
                subtotal = subtotal + Datos.precios[indice] * Datos.cantidades[indice];
                contadorItems = contadorItems + 1;
            }
            indice++;
        }// fin while
        if (contadorItems > 3) {
            if (subtotal > 0) {
                subtotalConDescuento = subtotal - (subtotal * 0.05);
                if (subtotalConDescuento > 50000) {
                    montoIva = subtotalConDescuento * 0.19;
// suma montoIva al subtotal con descuento
                    total = subtotalConDescuento + montoIva;
                    total = total + (total * 0.10);
                } else {
// suma montoIva al subtotal
                    montoIva = subtotalConDescuento * 0.19;
                    total = subtotalConDescuento + montoIva;
                }
            }// fin if subtotal>0

        } else {
            if (subtotal > 50000) {
                montoIva = subtotal * 0.19;
// suma montoIva al subtotal
                total = subtotal + montoIva;
                total = total + (total * 0.10);
            } else {
                montoIva = subtotal * 0.19;
                total = subtotal + montoIva;
            }
        }// fin if-else contadorItems
        Datos.estadoMesa = 1;
        Datos.totalActual = total;
        return total;
    }

    public static double procesar(double precio, double cantidad, double descuento, double tasaIva, double tasaPropina, int numItems, boolean aplicaPropina) {
        double resultado = 0;
        double montoIva = 0;
        double montoPropina = 0;
        double montoIvaTemporal = 0;
// calcula subtotal con cantidad
        resultado = precio * cantidad;
        if (descuento > 0) {
// aplica descuento
            resultado = resultado - (resultado * descuento);
        }
// calcula montoIva
        montoIva = resultado * tasaIva;
        montoIvaTemporal = montoIva;
        resultado = resultado + montoIvaTemporal;
        if (aplicaPropina) {
// aplica propina si corresponde
            montoPropina = resultado * tasaPropina;
            resultado = resultado + montoPropina;
        }
        if (numItems > 3) {
            resultado = resultado - (resultado * 0.01);
        }
        return resultado;
    }
}
