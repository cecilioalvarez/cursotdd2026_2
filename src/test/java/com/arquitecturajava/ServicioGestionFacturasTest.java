package com.arquitecturajava;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class ServicioGestionFacturasTest {

    @Test
    void facturaValidaSeRegistra() {

        //Arrange
        Factura f = new Factura(1, "informatica", 599);

        ServicioValidacionFacturas servicioValidacion = mock(ServicioValidacionFacturas.class);
        ServicioFacturaRegistro servicioRegistro = mock(ServicioFacturaRegistro.class);

        //configurar el mock
        when(servicioValidacion.esValida("informatica", 599)).thenReturn(true);

        ServicioGestionFacturas servicioGestion = new ServicioGestionFacturas(servicioValidacion, servicioRegistro);

        //Act
        boolean resultado = servicioGestion.registrarYValidar(f);

        //Assert
        verify(servicioValidacion).esValida("informatica", 200);
        verify(servicioRegistro).registrar(f);

        assertTrue(resultado);

   
    }

    @Test
    void facturaNoValidaNoSeRegistra() {

        //Arrange
        Factura f = new Factura(2, "informatica", 600);

        ServicioValidacionFacturas servicioValidacion = mock(ServicioValidacionFacturas.class);
        ServicioFacturaRegistro servicioRegistro = mock(ServicioFacturaRegistro.class);
        when(servicioValidacion.esValida("informatica", 600)).thenReturn(false);

        ServicioGestionFacturas servicioGestion = new ServicioGestionFacturas(servicioValidacion, servicioRegistro);

        //Act
        boolean resultado = servicioGestion.registrarYValidar(f);

        //Assert
        assertFalse(resultado);
        verify(servicioRegistro, never()).registrar(f);
    }
}
