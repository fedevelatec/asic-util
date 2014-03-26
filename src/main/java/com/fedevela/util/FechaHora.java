package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;


public class FechaHora extends Thread {
    private boolean activo;
    private JTextField caja;

    public FechaHora(JTextField caja) {
        this.caja = caja;
        setActivo(true);
    }

    public void run() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        while(isActivo()) {
            caja.setText(formato.format(new Date(System.currentTimeMillis())));
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    //Regresa el valor del atributo activo
    public boolean isActivo() {
        return activo;
    }

    //Asigna un valor al atributo activo
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
