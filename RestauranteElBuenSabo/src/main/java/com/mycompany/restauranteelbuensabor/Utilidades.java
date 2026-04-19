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

    public static boolean hayProductosEnPedido(Pedido pedido) {
        return pedido.tieneProductos();
    }

    public static void reiniciar(Pedido pedido, Mesa mesa) {
        pedido.limpiar();
        mesa.reiniciar();
    }
}
