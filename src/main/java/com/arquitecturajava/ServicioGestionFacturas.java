package com.arquitecturajava;

public class ServicioGestionFacturas {

    private final ServicioValidacionFacturas servicioValidacion;
    private final ServicioFacturaRegistro servicioRegistro;

    public ServicioGestionFacturas(ServicioValidacionFacturas servicioValidacion,
            ServicioFacturaRegistro servicioRegistro) {
        this.servicioValidacion = servicioValidacion;
        this.servicioRegistro = servicioRegistro;
    }

    public boolean registrarYValidar(Factura factura) {
        if (!servicioValidacion.esValida(factura.getConcepto(), factura.getImporte())) {
            return false;
        }
        servicioRegistro.registrar(factura);
        return true;
    }
}
