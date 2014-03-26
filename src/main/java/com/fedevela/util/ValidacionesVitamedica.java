package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */


public class ValidacionesVitamedica {

    public static boolean esEnteroLargo(String cadena) {
        boolean ok = true;

        try {
            Long valor = Long.parseLong(cadena);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
}
