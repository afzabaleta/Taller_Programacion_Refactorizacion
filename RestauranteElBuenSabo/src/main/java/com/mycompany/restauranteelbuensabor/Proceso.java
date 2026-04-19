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

    public static Factura generarFactura(Pedido pedido, int numeroFactura) {
        return new Factura(pedido, numeroFactura);
    }

}
