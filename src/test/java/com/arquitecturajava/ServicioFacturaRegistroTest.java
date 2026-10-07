package com.arquitecturajava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServicioFacturaRegistroTest {

    private final ServicioFacturaRegistro servicio = new ServicioFacturaRegistro();
    private final ByteArrayOutputStream salida = new ByteArrayOutputStream();
    private PrintStream consolaOriginal;

    @BeforeEach
    void capturarConsola() {
        consolaOriginal = System.out;
        System.setOut(new PrintStream(salida));
    }

    @AfterEach
    void restaurarConsola() {
        System.setOut(consolaOriginal);
    }

    @Test
    void registrarMuestraQueLaFacturaEstaRegistrada() {
        servicio.registrar(new Factura(1, "informatica", 300));
        assertEquals("La factura esta registrada", salida.toString().trim());
    }
}
