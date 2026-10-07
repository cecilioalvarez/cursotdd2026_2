package com.arquitecturajava;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ServicioValidacionFacturasTest {

    private final ServicioValidacionFacturas servicio = new ServicioValidacionFacturas();

    @Test
    void informaticaMenorDeSeiscientosEsValida() {

        assertTrue(servicio.esValida("informatica", 0));
        assertTrue(servicio.esValida("informatica", 500));
        assertTrue(servicio.esValida("informatica", 599.99));
    }

    @Test
    void informaticaDeSeiscientosOMasNoEsValida() {
        assertFalse(servicio.esValida("informatica", 600));
        assertFalse(servicio.esValida("informatica", 1000));
    }

    @Test
    void marketingMenorDeMilEsValida() {
        assertTrue(servicio.esValida("marketing", 0));
        assertTrue(servicio.esValida("marketing", 999.99));
    }

    @Test
    void marketingDeMilOMasNoEsValida() {
        assertFalse(servicio.esValida("marketing", 1000));
        assertFalse(servicio.esValida("marketing", 2000));
    }

    @Test
    void papeleriaMenorDeDoscientosEsValida() {
        assertTrue(servicio.esValida("papeleria", 0));
        assertTrue(servicio.esValida("papeleria", 199.99));
    }

    @Test
    void papeleriaDeDoscientosOMasNoEsValida() {
        assertFalse(servicio.esValida("papeleria", 200));
        assertFalse(servicio.esValida("papeleria", 500));
    }

    @Test
    void conceptoNoReconocidoNoEsValido() {
        assertFalse(servicio.esValida("viajes", 10));
        assertFalse(servicio.esValida("", 10));
        assertFalse(servicio.esValida(null, 10));
    }

    @Test
    void conceptoNoDistingueMayusculas() {
        assertTrue(servicio.esValida("Informatica", 100));
        assertTrue(servicio.esValida("MARKETING", 100));
    }
}
