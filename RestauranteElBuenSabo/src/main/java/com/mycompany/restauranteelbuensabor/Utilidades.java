/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Utilidades {

    public static double calcular(double precio, double cantidad, double descuento, double tasaIva, double tasaPropina, int numItems, boolean aplicaPropina) {
        double resultado = 0;
        double montoIva = 0;
        double resultadoFinal = 0;
// calcula el resultado
        resultado = precio * cantidad;
        if (descuento > 0) {
            resultado = resultado - (resultado * descuento);
        }
        montoIva = resultado * tasaIva;
        resultado = resultado + montoIva;
        if (aplicaPropina) {
            resultado = resultado + (resultado * tasaPropina);
        }
// imprime restaurante
        System.out.println("RESTAURANTE EL BUEN SABOR - calculo aplicado");
        resultadoFinal = resultado;
        return resultadoFinal;
    }

    public static boolean hayProductosEnPedido() {
        int contadorItems = 0;
        int indice = 0;
        while (indice < Datos.cantidades.length) {
            if (Datos.cantidades[indice] > 0) {
                contadorItems = contadorItems + 1;
            }
            indice++;
        }// fin while
// reinicia si no hay nada - efecto secundario no documentado
        if (contadorItems == 0) {
            Datos.totalActual = 0;
            Datos.textoTemporal = "";
        }
        return contadorItems > 0;
    }

    public static void reiniciar() {

        int indice = 0;
        while (indice < Datos.cantidades.length) {
            Datos.cantidades[indice] = 0;
            indice++;
        }
        Datos.totalActual = 0;
        Datos.estadoMesa = 0;
        Datos.numeroMesa = 0;
        Datos.textoTemporal = "";
    }
}
