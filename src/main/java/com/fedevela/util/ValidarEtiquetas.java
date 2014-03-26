package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */


public class ValidarEtiquetas {
    //Constructor
    public ValidarEtiquetas() {
    }


    //Verifica si es una etiqueta de expediente
    public boolean etiquetaExpediente(String expediente) throws Exception {
        boolean ok = true;

        try {
            if (expediente.length() != 11)
                ok = false;
            else if (!(expediente.startsWith("U") || expediente.startsWith("u")))
                ok = false;

            long etiquetaExpediente = Long.parseLong(expediente.trim().substring(1, expediente.trim().length()));
        }
        catch(Exception e) {
            ok = false;
            e.printStackTrace();
            Log.getLogger().severe(e.getMessage().trim());
            throw new Exception(e.getMessage().trim());
        }
        finally {
            return ok;
        }
    }


    //Verifica si es una etiqueta de documento
    public boolean etiquetaDocumento(String documento) throws Exception {
        boolean ok = true;

        try {
            if (documento.length() != 12)
                ok = false;
            else if (!(documento.startsWith("T") || documento.startsWith("t")))
                ok = false;

            long etiquetaDocumento = Long.parseLong(documento.trim().substring(1, documento.trim().length()));
        }
        catch(Exception e) {
            ok = false;
            e.printStackTrace();
            Log.getLogger().severe(e.getMessage().trim());
            throw new Exception(e.getMessage().trim());
        }
        finally {
            return ok;
        }
    }


    public boolean esLong(String valor) throws Exception {
        boolean ok = false;

        try {
            Long.parseLong(valor);
            ok = true;
        }
        catch(Exception e) {
            Log.getLogger().severe(e.getMessage().trim());
            throw new Exception(e.getMessage().trim());
        }
        finally {
            return ok;
        }
    }

    public boolean validaEtiq(String etiqueta, int op) {
        boolean ok = false;

        try {
            switch (op) {
                case 1:
                    //Expediente
                    if ((etiqueta.length() == 11) && (etiqueta.substring(0, 1).equalsIgnoreCase("U"))) {
                        ok = true;
                    }
                    break;
                case 2:
                    //Documento
                    if ((etiqueta.length() == 12) && (etiqueta.substring(0, 1).equalsIgnoreCase("T"))) {
                        ok = true;
                    }
                    break;

                case 3:
                    //Caja
                    if ((etiqueta.length() == 9) && (etiqueta.substring(0, 1).equalsIgnoreCase("S"))) {
                        ok = true;
                    }
                    break;
            }
            Long.parseLong(etiqueta.trim().substring(1));
        } catch (Exception e) {
            ok = false;
        }

        return ok;
    }
}

