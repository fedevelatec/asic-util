package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class SHA1 {
    //Encriptaci�n Base64
    public static String encriptarBase64(String password) throws IllegalStateException {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("SHA");
        }
        catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }

        try {
            md.update(password.getBytes("UTF-8"));
        }
        catch(UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }

        byte raw[] = md.digest();
        return(new BASE64Encoder()).encode(raw);
    }


    //Encriptaci�n Hexadecimal
    public static String encriptarHexadecimal(String password) throws IllegalStateException {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("SHA");
        }
        catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }

        try {
            md.update(password.getBytes("UTF-8"));
        }
        catch(UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }

        byte raw[] = md.digest();
        return toHexadecimal(raw);
    }


    //Conversi�n de hexadecimal a cadena de caracteres
    private static String toHexadecimal(byte[] datos) {
        String resultado = "\\";
        ByteArrayInputStream input = new ByteArrayInputStream(datos);
        String cadAux;
        int leido = input.read();
        while (leido != -1) {
            cadAux = Integer.toHexString(leido);
            if (cadAux.length() < 2)
                resultado += "0";

            resultado += cadAux;
            leido = input.read();
        }

        return resultado;
    }
}

