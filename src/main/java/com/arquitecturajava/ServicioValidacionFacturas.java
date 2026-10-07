package com.arquitecturajava;

import java.util.Map;

public class ServicioValidacionFacturas {

    private static final Map<String, Double> LIMITES = Map.of(
            "informatica", 600.0,
            "marketing", 1000.0,
            "papeleria", 200.0);

    public boolean esValida(String concepto, double importe) {
        if (concepto == null) {
            return false;
        }
        Double limite = LIMITES.get(concepto.toLowerCase());
        return limite != null && importe < limite;
    }
}
