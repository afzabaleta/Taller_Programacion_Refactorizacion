/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restauranteelbuensabor;

import java.util.Scanner;

/**
 *
 * @author alfre
 */
public class RestauranteElBuenSabor {

    private static final Scanner lector = new Scanner(System.in);
    private static final Carta carta = new Carta();
    private static final Pedido pedido = new Pedido();
    private static final Mesa mesa = new Mesa();
    private static int numeroFactura = 1;

    public static void main(String[] args) {
        int opcionMenu = 0;
        boolean ejecutando = true;

        imprimirBienvenida();

        while (ejecutando) {
            imprimirMenu();
            opcionMenu = lector.nextInt();
            ejecutando = procesarOpcion(opcionMenu);
        }

        lector.close();
    }

    private static void imprimirBienvenida() {
        System.out.println("========================================");
        System.out.println("    RESTAURANTE " + Configuracion.NOMBRE_RESTAURANTE);
        System.out.println("    " + Configuracion.DIRECCION);
        System.out.println("    NIT: " + Configuracion.NIT);
        System.out.println("========================================");
    }

    private static void imprimirMenu() {
        System.out.println("1. Ver carta");
        System.out.println("2. Agregar producto al pedido");
        System.out.println("3. Ver pedido actual");
        System.out.println("4. Generar factura");
        System.out.println("5. Nueva mesa");
        System.out.println("0. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
    }

    private static boolean procesarOpcion(int opcionMenu) {
        switch (opcionMenu) {
            case 1:
                Imprimir.mostrarCarta(carta);
                break;
            case 2:
                agregarProducto();
                break;
            case 3:
                mostrarPedidoActual();
                break;
            case 4:
                generarFactura();
                break;
            case 5:
                nuevaMesa();
                break;
            case 0:
                System.out.println("Hasta luego!");
                return false;
            default:
                System.out.println("Opcion no valida. Seleccione entre 0 y 5.");
        }
        System.out.println();
        return true;
    }

    private static void agregarProducto() {
        System.out.println("--- AGREGAR PRODUCTO ---");
        System.out.print("Numero de producto (1-" + carta.totalProductos() + "): ");
        int numeroProducto = lector.nextInt();
        System.out.print("Cantidad: ");
        int cantidad = lector.nextInt();

        Producto producto = carta.buscarPorNumero(numeroProducto);

        if (producto == null) {
            System.out.println("Producto no existe. La carta tiene " + carta.totalProductos() + " productos.");
            return;
        }
        if (cantidad <= 0) {
            System.out.println("Cantidad invalida. Ingrese un valor positivo.");
            return;
        }
        if (!mesa.estaActiva()) {
            System.out.print("Ingrese numero de mesa: ");
            int numeroMesa = lector.nextInt();
            mesa.activar(numeroMesa);
        }

        pedido.agregarItem(producto, cantidad);
        System.out.println("Producto agregado al pedido.");
        System.out.println("  -> " + producto.getNombre() + " x" + cantidad);
    }

    private static void mostrarPedidoActual() {
        if (!Utilidades.hayProductosEnPedido(pedido)) {
            System.out.println("No hay productos en el pedido actual.");
            System.out.println("Use la opcion 2 para agregar productos.");
            return;
        }
        Imprimir.mostrarPedido(pedido);
    }

    private static void generarFactura() {
        if (!Utilidades.hayProductosEnPedido(pedido)) {
            System.out.println("No se puede generar factura.");
            System.out.println("Use la opcion 2 para agregar productos primero.");
            return;
        }
        Factura factura = Proceso.generarFactura(pedido, numeroFactura);
        numeroFactura++;
        Imprimir.imprimirFacturaCompleta(factura);
    }

    private static void nuevaMesa() {
        Utilidades.reiniciar(pedido, mesa);
        System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
    }
}
