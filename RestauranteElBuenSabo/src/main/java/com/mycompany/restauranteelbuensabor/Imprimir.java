/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Imprimir {

    public static void mostrarCarta() {
        System.out.println("========================================");
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println("========================================");
        int i = 0;
        while (i < Datos.nombre.length) {
            System.out.printf("%d. %-22s $%,.0f%n", (i + 1), Datos.nombre[i], Datos.precios[i]);
            i++;
        }// fin while
        System.out.println("========================================");
    }

    public static void mostrarPedido() {
        double subtotal = 0;
        int i = 0;
        System.out.println("--- PEDIDO ACTUAL ---");
        while (i < Datos.nombre.length) {
            if (Datos.cantidades[i] > 0) {
// imprime producto con cantidad y subtotal parcial
                System.out.printf("%-20s x%-6d $%,.0f%n", Datos.nombre[i], Datos.cantidades[i], (Datos.precios[i] * Datos.cantidades[i]));
// suma al subtotal
                subtotal = subtotal + Datos.precios[i] * Datos.cantidades[i];
            }
            i++;
        }// fin while
        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotal);
    }

    public static void imprimirFacturaCompleta() {
        double subtotal = 0;
        double montoIva = 0;
        double total = 0;
        double montoPropina = 0;
        int contadorItems = 0;
        double subtotalConDescuento = 0;
// calcula subtotal otra vez
        int i = 0;
        while (i < Datos.nombre.length) {
            if (Datos.cantidades[i] > 0) {
                subtotal = subtotal + Datos.precios[i] * Datos.cantidades[i];
                contadorItems = contadorItems + 1;
            }
            i++;
        }// fin while
        if (contadorItems > 3) {
            subtotalConDescuento = subtotal - (subtotal * 0.05);
        } else {
            subtotalConDescuento = subtotal;
        }
        if (subtotalConDescuento > 50000) {
            montoIva = subtotalConDescuento * 0.19;
            total = subtotalConDescuento + montoIva;
            montoPropina = total * 0.10;
            total = total + montoPropina;
        } else {
            montoIva = subtotalConDescuento * 0.19;
            total = subtotalConDescuento + montoIva;
            montoPropina = 0;
        }// fin if-else
        String sep = "========================================";
        System.out.println(sep);
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println(sep);
        System.out.printf("FACTURA No. %03d%n", Datos.numeroFactura);
        System.out.println("----------------------------------------");
// imprime cada item del pedido
        int j = 0;
        while (j < Datos.nombre.length) {
            if (Datos.cantidades[j] > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n", Datos.nombre[j], Datos.cantidades[j], (Datos.precios[j] * Datos.cantidades[j]));
            }
            j++;
        }// fin while
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotalConDescuento);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", montoIva);
        if (montoPropina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", montoPropina);
        }// fin if montoPropina
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", total);
        System.out.println(sep);
        System.out.println("Gracias por su visita!");
        System.out.println("El Buen Sabor - Valledupar");
        System.out.println(sep);
// actualiza estado e incrementa factura - tres responsabilidades en un metodo
        Datos.numeroFactura = Datos.numeroFactura + 1;
        Datos.estadoMesa = 0;
        Datos.totalActual = total;
    }

    public static void imprimirFacturaResumen() {
        double subtotal = 0;
        double montoIva = 0;
        double total = 0;
        double montoPropina = 0;
        int contadorItems = 0;
        double subtotalConDescuento = 0;
// calcula subtotal otra vez igual que en imprimirFacturaCompleta
        int i = 0;
        while (i < Datos.nombre.length) {
            if (Datos.cantidades[i] > 0) {
                subtotal = subtotal + Datos.precios[i] * Datos.cantidades[i];
                contadorItems = contadorItems + 1;
            }
            i++;
        }// fin while
        if (contadorItems > 3) {
            subtotalConDescuento = subtotal - (subtotal * 0.05);
        } else {
            subtotalConDescuento = subtotal;
        }
        if (subtotalConDescuento > 50000) {
            montoIva = subtotalConDescuento * 0.19;
            total = subtotalConDescuento + montoIva;
            montoPropina = total * 0.10;
            total = total + montoPropina;
        } else {
            montoIva = subtotalConDescuento * 0.19;
            total = subtotalConDescuento + montoIva;
            montoPropina = 0;
        }// fin if-else
        String sep = "========================================";
        System.out.println(sep);
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println(sep);
        System.out.printf("FACTURA No. %03d (RESUMEN)%n", Datos.numeroFactura);
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotalConDescuento);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", montoIva);
        if (montoPropina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", montoPropina);
        }// fin if montoPropina
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", total);
        System.out.println(sep);
    }
}
