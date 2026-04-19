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

    private static void imprimirTotales(Factura factura) {
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", factura.calcularSubtotalConDescuento());
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", factura.calcularIVA());
        if (factura.calcularPropina() > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", factura.calcularPropina());
        }
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", factura.calcularTotal());
    }

    public static void mostrarCarta(Carta carta) {
        imprimirEncabezado();
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println("========================================");
        int indice = 0;
        for (Producto producto : carta.getProductos()) {
            indice++;
            System.out.printf("%d. %-22s $%,.0f%n", indice, producto.getNombre(), producto.getPrecio());
        }
        System.out.println("========================================");
    }

    public static void mostrarPedido(Pedido pedido) {
        System.out.println("--- PEDIDO ACTUAL ---");
        for (ItemPedido item : pedido.getItems()) {
            System.out.printf("%-20s x%-6d $%,.0f%n", item.getProducto().getNombre(), item.getCantidad(), item.calcularSubtotal());
        }
        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", pedido.calcularSubtotal());
    }

    public static void imprimirFacturaCompleta(Factura factura) {
        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d%n", factura.getNumero());
        System.out.println("----------------------------------------");
        for (ItemPedido item : factura.getPedido().getItems()) {
            System.out.printf("%-20s x%-6d $%,.0f%n", item.getProducto().getNombre(), item.getCantidad(), item.calcularSubtotal());
        }
        imprimirTotales(factura);
        System.out.println("========================================");
        System.out.println("Gracias por su visita!");
        System.out.println(Configuracion.NOMBRE_RESTAURANTE + " - Valledupar");
        System.out.println("========================================");
    }
}
