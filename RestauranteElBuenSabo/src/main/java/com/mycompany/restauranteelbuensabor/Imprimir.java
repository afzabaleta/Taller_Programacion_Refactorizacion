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

    private static void imprimirEncabezado() {
        System.out.println("========================================");
        System.out.println("    RESTAURANTE " + Configuracion.NOMBRE_RESTAURANTE);
        System.out.println("    " + Configuracion.DIRECCION);
        System.out.println("    NIT: " + Configuracion.NIT);
        System.out.println("========================================");
    }

    private static void imprimirTotales(double subtotalConDescuento, double montoIva, double montoPropina, double total) {
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotalConDescuento);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", montoIva);
        if (montoPropina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", montoPropina);
        }
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", total);
    }

    public static void mostrarCarta() {
        imprimirEncabezado();
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println("========================================");
        int indice = 0;
        while (indice < Datos.nombres.length) {
            System.out.printf("%d. %-22s $%,.0f%n", (indice + 1), Datos.nombres[indice], Datos.precios[indice]);
            indice++;
        }
        System.out.println("========================================");
    }

    public static void mostrarPedido() {
        double subtotal = 0;
        int indice = 0;
        System.out.println("--- PEDIDO ACTUAL ---");
        while (indice < Datos.nombres.length) {
            if (Datos.cantidades[indice] > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n", Datos.nombres[indice], Datos.cantidades[indice], (Datos.precios[indice] * Datos.cantidades[indice]));
                subtotal = subtotal + Datos.precios[indice] * Datos.cantidades[indice];
            }
            indice++;
        }
        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotal);
    }

    public static void imprimirFacturaCompleta() {
        double subtotal = Proceso.calcularSubtotal();
        double subtotalConDescuento = Proceso.aplicarDescuento(subtotal);
        double montoIva = Proceso.calcularIVA(subtotalConDescuento);
        double montoPropina = Proceso.calcularPropina(subtotalConDescuento);
        double total = subtotalConDescuento + montoIva + montoPropina;

        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d%n", Datos.numeroFactura);
        System.out.println("----------------------------------------");

        int indice = 0;
        while (indice < Datos.nombres.length) {
            if (Datos.cantidades[indice] > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n", Datos.nombres[indice], Datos.cantidades[indice], (Datos.precios[indice] * Datos.cantidades[indice]));
            }
            indice++;
        }

        imprimirTotales(subtotalConDescuento, montoIva, montoPropina, total);
        System.out.println("========================================");
        System.out.println("Gracias por su visita!");
        System.out.println(Configuracion.NOMBRE_RESTAURANTE + " - Valledupar");
        System.out.println("========================================");

        Datos.numeroFactura = Datos.numeroFactura + 1;
        Datos.estadoMesa = 0;
        Datos.totalActual = total;
    }

    public static void imprimirFacturaResumen() {
        double subtotal = Proceso.calcularSubtotal();
        double subtotalConDescuento = Proceso.aplicarDescuento(subtotal);
        double montoIva = Proceso.calcularIVA(subtotalConDescuento);
        double montoPropina = Proceso.calcularPropina(subtotalConDescuento);
        double total = subtotalConDescuento + montoIva + montoPropina;

        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d (RESUMEN)%n", Datos.numeroFactura);
        imprimirTotales(subtotalConDescuento, montoIva, montoPropina, total);
        System.out.println("========================================");
    }
}
