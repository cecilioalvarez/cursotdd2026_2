package com.arquitecturajava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FacturaTest {

    @Test
    void guardaIdConceptoEImporte() {
        Factura factura = new Factura(1, "informatica", 300);
        assertEquals(1, factura.getId());
        assertEquals("informatica", factura.getConcepto());
        assertEquals(300, factura.getImporte());
    }
}
