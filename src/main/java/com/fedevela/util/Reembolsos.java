package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */
public class Reembolsos {

    /**
     * Trata los casos especiales de 13 digitos, quita los dos primeros
     * y el ultimo, despues le concatena dos ceros al final y el resultado
     * tiene una longitud igual a 12
     * @param codigoBarra
     * @return
     */
    public static String tratarCodigoEspecial(String codigoBarra) {

        if (codigoBarra.trim().length() == 13) {
            codigoBarra = codigoBarra.substring(2, codigoBarra.length() - 1);
            codigoBarra += "00";
        }
        return codigoBarra;
    }

    /**
     * Si el codigo contiene ceros al principio de la cadena, estos son pasados al final
     * ejemplo 00802143 ---> 80214300
     * @param codigoBarra
     * @return
     */
    public static String tratarCodigo(String codigoBarra) {
        char caracter;

        if (codigoBarra.length() > 0) {
            int pos = 0;
            for (int i = 0; i < codigoBarra.length(); i++) {
                caracter = codigoBarra.charAt(i);
                if (caracter == '0') {
                    pos++;
                } else {
                    break;
                }
            }

            codigoBarra = codigoBarra.substring(pos, codigoBarra.length()) + codigoBarra.substring(0, pos);
        }

        return codigoBarra;
    }

}
