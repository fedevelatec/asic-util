package com.fedevela.util;


/**
 * Created by fvelazquez on 26/03/14.
 */

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JDialog;


public class CentraDialog {
    private Toolkit kit = Toolkit.getDefaultToolkit();
    private Dimension tamañoVtna = kit.getScreenSize();
    private int alto = tamañoVtna.height;
    private int ancho = tamañoVtna.width;

    private Object ventana;
    private JDialog dialog;
    private static CentraDialog singleton;
    /**
     * Creates a new instance of CentraFrames
     */
    public CentraDialog() {

    }

    public void Centra(Object ventana){
        int ancho1, alto1;
        this.dialog=(JDialog) ventana;
        ancho1=Math.round((this.ancho-this.dialog.getSize().width)/2);
        alto1=Math.round((this.alto-this.dialog.getSize().height)/2);
        this.dialog.setLocation(ancho1, alto1);
        this.dialog.setModal(true);
        this.dialog.setVisible(true);
    }
    public void Centra1(Object ventana){
        int ancho1, alto1;
        this.dialog=(JDialog) ventana;
        ancho1=Math.round((this.ancho-this.dialog.getSize().width)/2);
        alto1=Math.round((this.alto-this.dialog.getSize().height)/2);
        this.dialog.setLocation(ancho1, alto1);
        //this.dialog.setModal(true);

    }
    public void AllWindow(Object ventana){
        int ancho1, alto1;
        this.dialog=(JDialog) ventana;
        ancho1=this.ancho;
        alto1=this.alto;
        this.dialog.setSize(ancho1, alto1);

        //this.dialog.setModal(true);
        this.dialog.setVisible(true);
    }

    public static CentraDialog getInstance(){
        if(singleton == null){
            singleton = new CentraDialog();
        }

        return singleton;
    }


}


