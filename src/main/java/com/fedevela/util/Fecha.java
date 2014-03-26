package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {

    /**
     * Le da formato a un Date segun el formato pasado como parametro
     * ejem. "yyyy-MM-dd"
     * @param date
     * @param formato
     * @return
     */
    public static String formatDate(Date date, String formato) {
        SimpleDateFormat formateador = new SimpleDateFormat(formato);

        return formateador.format(date);
    }

}