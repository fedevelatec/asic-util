package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */

import com.lowagie.text.Cell;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

public class Util {

    public static boolean isNumber(String valor) {
        boolean bandera = false;
        try {
            Integer.valueOf(valor);
            bandera = true;
        } catch (Exception e) {
            bandera = false;
        }

        return bandera;
    }

    public static boolean isEmptyString(String valor) {
        boolean bandera = false;

        if (valor.trim().length() < 1) {
            bandera = true;
        }

        return bandera;
    }

    public static String corregirNumero(String s) {
        System.out.println("Numero original: " + s);

        boolean bandera = false;
        String numero = "";
        char caracter;


        for (int i = 0; i < s.length(); i++) {
            caracter = s.charAt(i);
            bandera = false;

            for (int j = 0; j < Constantes.NUMEROS.length; j++) {
                if (String.valueOf(caracter).equals(Constantes.NUMEROS[j])) {
                    bandera = true;
                    break;
                }
            }

            if (bandera) {
                numero += String.valueOf(caracter);
            }
        }

        System.out.println("Numero corregido: " + numero);
        return numero;
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

    /**
     * Trata los casos especiales de 13 digitos, quita los dos primeros
     * y el ultimo, despues le concatena dos ceros al final y el resultado
     * tiene una longitud igual a 12
     * @param codigoBarra
     * @return
     */
    public static String tratarCodigoEspecial(String codigoBarra) {

        codigoBarra = codigoBarra.substring(2, codigoBarra.length() - 1);
        codigoBarra += "00";
        return codigoBarra;
    }

    /**
     * Le da formato a un Date segun el formato pasado como parametro
     * ejem. "yyyy-MM-dd"
     * @param date
     * @param formato
     * @return
     */
    public static String formatDate(Date date, String formato) {
        SimpleDateFormat formateador = new SimpleDateFormat(formato);

        if (date != null) {
            return formateador.format(date);
        } else {
            return "---";
        }
    }

    /**
     * Pasa un dato de tipo Calendar a tipo String
     * con el formato año-mes-dia
     * @param calendar
     * @return
     */
    public static String calendarToString(Calendar calendar) {
        String date = "";

        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        int mes = calendar.get(Calendar.MONTH) + 1;
        int anio = calendar.get(Calendar.YEAR);

        date = anio + "-" + mes + "-" + dia;


        return date;
    }

    /**
     * Pasa un dato de tipo Date a tipo Calendar
     * @param date
     * @return
     */
    public static Calendar dateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(date.getYear(), date.getMonth(), date.getDay());

        return calendar;
    }

    /**
     * Obtiene el layout requerido
     * @param archivo
     * @return
     * @throws FileNotFoundException
     * @throws IOException

    public static <T> HSSFWorkbook getLayout(String archivo) throws FileNotFoundException, IOException {
    return new HSSFWorkbook(Util.class.getClassLoader().getResourceAsStream("layouts/" + archivo));
    }
     */
    /**
     *
     * @param <T>
     * @param archivo
     * @param remote
     * @return
     * @throws FileNotFoundException
     * @throws IOException

    public static <T> HSSFWorkbook getLayoutURL(String key, String rsc) throws FileNotFoundException, IOException {
    return new HSSFWorkbook(is(key, rsc));
    }


    public static <T> HSSFWorkbook getLayoutURL(String key) throws FileNotFoundException, IOException {
    return new HSSFWorkbook(is(key));
    }
     */
    public static <T> HSSFWorkbook getLayoutURL(String key, String rsc) throws FileNotFoundException, IOException {
        return new HSSFWorkbook(is(key, rsc));
    }

    /**
     *
     * @param key
     * @param resource
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static InputStream is(String key, String rsc) throws FileNotFoundException, IOException {
        ResourceBundle rb = ResourceBundle.getBundle("commons-property");
        return (new URL(rb.getString(key) + rsc)).openStream();
    }

    public static String getLayout(String key, String rsc) throws Exception {
        ResourceBundle rb = ResourceBundle.getBundle("commons-property");
        return (new URL(rb.getString(key) + rsc)).getFile();
    }

    public static InputStream is(String key) throws FileNotFoundException, IOException {
        ResourceBundle rb = ResourceBundle.getBundle("commons-property");
        return (new URL(rb.getString(key))).openStream();
    }

    /* Deprecated by jViera
    public static HSSFWorkbook getLayoutLocal(String archivo) throws FileNotFoundException, IOException {
    File path = new File("C:\\emc2f\\vitamedica\\produccion_calidad\\layouts\\" + archivo);
    InputStream inp = new FileInputStream(path.getCanonicalPath());
    HSSFWorkbook libro = new HSSFWorkbook(new POIFSFileSystem(inp));
    return libro;
    }
     *
     */
    /**
     * Trunca los decimales especificados en el parametro
     * @param numeroDecimales
     * @param decimal
     * @return
     */
    public static float truncarDecimales(int numeroDecimales, float decimal) {

        decimal = (float) (decimal * (java.lang.Math.pow(10, numeroDecimales)));
        decimal = java.lang.Math.round(decimal);
        decimal = (float) (decimal / java.lang.Math.pow(10, numeroDecimales));

        return decimal;
    }

    /**
     * Resta dos fechas
     * @param fechaInicio
     * @param fechaFin
     * @return
     */
    public static int restarFechas(Calendar fechaInicio, Calendar fechaFin) {
        int diasDiferencia = 0;

        //Las fehas son del mismo año
        if (fechaInicio.get(Calendar.YEAR) == fechaFin.get(Calendar.YEAR)) {
            diasDiferencia = fechaFin.get(Calendar.DAY_OF_YEAR) - fechaInicio.get(Calendar.DAY_OF_YEAR);
        } //Las fehas son de años diferentes
        else {
            long diferencia = fechaFin.getTimeInMillis() - fechaInicio.getTimeInMillis();
            try {
                diasDiferencia = (int) (diferencia / (1000 * 60 * 60 * 24));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return diasDiferencia;
    }

    /**
     * Obtiene el ultimo dia del mes, tomando como argumento el a�o y mes
     * @param anio
     * @param mes
     * @return
     */
    public static int ultimoDiaDelMes(int anio, int mes) {
        int ultimoDiaDelMes = 0;

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(anio, mes, 1);
        ultimoDiaDelMes = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);

        return ultimoDiaDelMes;
    }

    /**
     * Convierte los enteros dia, mes y anio en una fecha con formato dd/mm/yyyy
     * @param dia
     * @param mes
     * @param anio
     * @param separador
     * @return
     */
    public static String intToStringDate(int dia, int mes, int anio, String separador) {
        String fecha = "";

        fecha += String.valueOf(dia) + separador + String.valueOf(mes) + separador + String.valueOf(anio);

        return fecha;

    }

    public static void clonarRegionExcel(HSSFSheet hoja, HSSFCellStyle estilo, int columna) {
        HSSFCell celda = null;
        HSSFRow renglon = null;


        for (int i = 0; i < 5; i++) {
            //Creo el renglon
            renglon = hoja.createRow(i);
            celda = renglon.createCell(columna);
            celda.setCellStyle(estilo);

            celda = renglon.createCell(columna + 1);
            celda.setCellStyle(estilo);

            celda = renglon.createCell(columna + 2);
            celda.setCellStyle(estilo);

            celda = renglon.createCell(columna + 3);
            celda.setCellStyle(estilo);

            celda = renglon.createCell(columna + 4);
            celda.setCellStyle(estilo);

            celda = renglon.createCell(columna + 5);
            celda.setCellStyle(estilo);

            celda = renglon.createCell(columna + 6);
            celda.setCellStyle(estilo);

            celda = renglon.createCell(columna + 7);
            celda.setCellStyle(estilo);

            celda = renglon.createCell(columna + 8);
            celda.setCellStyle(estilo);

            celda = renglon.createCell(columna + 9);
            celda.setCellStyle(estilo);

            celda = renglon.createCell(columna + 10);
            celda.setCellStyle(estilo);
        }

        //hoja.addMergedRegion(new CellRangeAddress(0, 0, columna, columna + 10));

        //hoja.addMergedRegion(new CellRangeAddress(1, 1, columna, columna + 1));
        //hoja.addMergedRegion(new CellRangeAddress(1, 1, columna + 2, columna + 3));
        //hoja.addMergedRegion(new CellRangeAddress(1, 1, columna + 4, columna + 5));
        //hoja.addMergedRegion(new CellRangeAddress(1, 1, columna + 6, columna + 7));
        //hoja.addMergedRegion(new CellRangeAddress(1, 1, columna + 8, columna + 10));


    }

    public static HSSFCellStyle getEstiloBordeNumero(HSSFWorkbook wb) {

        HSSFCellStyle style = wb.createCellStyle();
        DataFormat format = wb.createDataFormat();

        style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        //style.setRightBorderColor(HSSFColor.BLACK.index);
        //style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        //style.setTopBorderColor(HSSFColor.BLACK.index);
        style.setDataFormat(format.getFormat("#,##0"));


        return style;
    }

    public static HSSFCellStyle getEstiloCifrasControl(HSSFWorkbook wb) {

        HSSFCellStyle style = wb.createCellStyle();
        DataFormat format = wb.createDataFormat();

        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        //style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        //style.setLeftBorderColor(HSSFColor.BLACK.index);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        //style.setRightBorderColor(HSSFColor.BLACK.index);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //style.setTopBorderColor(HSSFColor.BLACK.index);
        style.setDataFormat(format.getFormat("$#,##0.00"));

        return style;
    }

    public static HSSFCellStyle getEstiloBordePeso(HSSFWorkbook wb) {

        HSSFCellStyle style = wb.createCellStyle();
        DataFormat format = wb.createDataFormat();

        style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        //style.setRightBorderColor(HSSFColor.BLACK.index);
        //style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        //style.setTopBorderColor(HSSFColor.BLACK.index);
        style.setDataFormat(format.getFormat("$#,##0.00"));

        return style;
    }

    public static HSSFCellStyle getEstiloBordePorcentaje(HSSFWorkbook wb) {

        HSSFCellStyle style = wb.createCellStyle();
        DataFormat format = wb.createDataFormat();

        style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        //style.setRightBorderColor(HSSFColor.BLACK.index);
        //style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        //style.setTopBorderColor(HSSFColor.BLACK.index);
        style.setDataFormat(format.getFormat("0.00%"));

        return style;
    }

    public static HSSFCellStyle getEstiloBorde(HSSFWorkbook wb) {

        HSSFCellStyle style = wb.createCellStyle();

        style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        //style.setRightBorderColor(HSSFColor.BLACK.index);
        //style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        //style.setTopBorderColor(HSSFColor.BLACK.index);

        return style;
    }

    public static HSSFCellStyle getEstiloNegrita(HSSFWorkbook wb) {

        HSSFCellStyle style = wb.createCellStyle();

        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        HSSFFont font = wb.createFont();

        font.setFontName("Courier New");
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);

        return style;
    }

    public static HSSFCellStyle getEstiloNegritaPeso(HSSFWorkbook wb) {

        HSSFCellStyle style = wb.createCellStyle();
        DataFormat format = wb.createDataFormat();

        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        Font font = wb.createFont();

        font.setFontName("Courier New");
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);
        style.setDataFormat(format.getFormat("$#,##0.00"));


        return style;
    }

    public static HSSFCellStyle getEstiloNegritaNumero(HSSFWorkbook wb) {

        HSSFCellStyle style = wb.createCellStyle();
        DataFormat format = wb.createDataFormat();

        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        Font font = wb.createFont();

        font.setFontName("Courier New");
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);
        style.setDataFormat(format.getFormat("#,##0"));


        return style;
    }

    public static HSSFCellStyle getEstiloNegritaPorcentaje(HSSFWorkbook wb) {

        HSSFCellStyle style = wb.createCellStyle();
        DataFormat format = wb.createDataFormat();

        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        Font font = wb.createFont();

        font.setFontName("Courier New");
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        font.setColor(IndexedColors.WHITE.getIndex());
        style.setFont(font);
        style.setDataFormat(format.getFormat("0.00%"));


        return style;
    }

    public static void getEstiloAzul(HSSFSheet hoja, CellStyle styleAzulNumero, CellStyle styleAzulPeso, CellStyle styleAzulPorcentaje) {

        HSSFRow renglon = hoja.getRow(4);
        HSSFCell celda = renglon.getCell(3);
        styleAzulNumero = celda.getCellStyle();

        celda = renglon.getCell(2);
        styleAzulPeso = celda.getCellStyle();

        celda = renglon.getCell(7);
        styleAzulPorcentaje = celda.getCellStyle();
    }

    public static String getPeriodo(int anio, int mes) {
        String periodo = "";

        if (mes < 10) {
            periodo = "0" + String.valueOf(mes);
        } else {
            periodo = String.valueOf(mes);
        }

        periodo += String.valueOf(anio);

        return periodo;
    }

    public static int calcularRenglonTipoFiscal1(int anio, int mes) {

        int renglon = 3;

        for (int i = 2009; i < anio; i++) {
            renglon += 12;
        }

        for (int j = 1; j < mes; j++) {
            renglon++;
        }

        return renglon;
    }



    public static String buildProcedureCall(String packageName, String procedureName, int paramCount) {
        StringBuffer sb = new StringBuffer("{call " + packageName + "." + procedureName + "(");
        for (int n = 1; n <= paramCount; n++) {
            sb.append("?");
            if (n < paramCount) {
                sb.append(",");
            }
        }
        return sb.append(")}").toString();
    }

    public static String quitarEnters(String cadena) {
        String cadenaSinEnters = "";
        char caracter;

        for (int i = 0; i < cadena.length(); i++) {
            caracter = cadena.charAt(i);

            if (caracter == '\n' || caracter == '	') {
                cadenaSinEnters += " ";
            } else {
                cadenaSinEnters += String.valueOf(caracter);
            }
        }

        return cadenaSinEnters;
    }

    public static boolean tieneEnters(String cadena) {
        char caracter;
        boolean bandera = false;

        for (int i = 0; i < cadena.length(); i++) {
            caracter = cadena.charAt(i);

            if (caracter == '\n' || caracter == '	') {
                bandera = true;
                break;
            }
        }

        return bandera;
    }

    public static boolean esBancomer(String cliente) {
        boolean bandera = false;

        if (cliente.toUpperCase().indexOf("BANCOMER") != -1) {
            bandera = true;
        }


        return bandera;
    }

    public static int getColumna(int mes) {

        int columna = 0;

        switch (mes) {
            case 1:
                columna = 3;
                break;
            case 2:
                columna = 13;
                break;
            case 3:
                columna = 23;
                break;
            case 4:
                columna = 33;
                break;
            case 5:
                columna = 43;
                break;
            case 6:
                columna = 53;
                break;
            case 7:
                columna = 63;
                break;
            case 8:
                columna = 73;
                break;
            case 9:
                columna = 83;
                break;
            case 10:
                columna = 93;
                break;
            case 11:
                columna = 103;
                break;
            case 12:
                columna = 113;
                break;
            default:
                columna = 3;
                break;
        }

        return columna;
    }

    public static int getColumnaFarmacia(int mes) {

        int columna = 0;

        switch (mes) {
            case 1:
                columna = 2;
                break;
            case 2:
                columna = 8;
                break;
            case 3:
                columna = 14;
                break;
            case 4:
                columna = 20;
                break;
            case 5:
                columna = 26;
                break;
            case 6:
                columna = 32;
                break;
            case 7:
                columna = 38;
                break;
            case 8:
                columna = 44;
                break;
            case 9:
                columna = 50;
                break;
            case 10:
                columna = 56;
                break;
            case 11:
                columna = 62;
                break;
            case 12:
                columna = 68;
                break;
            default:
                columna = 2;
                break;
        }

        return columna;
    }

    public static double truncar(double nD, int nDec) {
        if (nD > 0) {
            nD = Math.floor(nD * Math.pow(10, nDec)) / Math.pow(10, nDec);
        } else {
            nD = Math.ceil(nD * Math.pow(10, nDec)) / Math.pow(10, nDec);
        }

        return nD;
    }

    public static float truncar(float nD, int nDec) {

        if (nD > 0) {
            nD = (float) (Math.floor(nD * Math.pow(10, nDec)) / Math.pow(10, nDec));
        } else {
            nD = (float) (Math.ceil(nD * Math.pow(10, nDec)) / Math.pow(10, nDec));
        }

        return nD;
    }

    public static String nombrePC() {

        String maquina = null;

        try {
            InetAddress address = InetAddress.getLocalHost();
            maquina = address.getHostName();

            if (maquina == null || maquina.length() < 1) {
                maquina = "No encontrada";
            }
        } catch (Exception e) {
            maquina = "No encontrada";
        }

        return maquina;
    }

    public static String conocerIp() {
        String ip = null;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();

            if (ip == null || ip.length() < 1) {
                ip = "Desconocida";
            }

        } catch (UnknownHostException ex) {
            ip = "Desconocida";
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ip;
    }

    /**
     * Metodo que abre una ventana de dialogo para seleccionar una ruta y retornarla
     * @param parent
     * @param extension
     * @return
     */
    public static File getRuta(Component parent) {
        //Creo mi objeto File Chooser
        JFileChooser fileChooser = new JFileChooser();

        //Aqui le indico que seleccione carpetas y no archivos
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        //Checo si apreto el boton aceptar o cancelar
        int seleccion = fileChooser.showOpenDialog(parent);

        File fichero = null;

        //Si apreto el boton aceptar continuo
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            fichero = fileChooser.getSelectedFile();
        }

        return fichero;
    }

    public static String toEntero(String valor) {
        String valorNew = "";

        int pos = valor.indexOf(".");

        if (pos != -1) {
            valorNew = valor.substring(0, pos - 1);
        } else {
            valorNew = valor;
        }

        return valorNew;
    }

    public static double divide(Long valor1, Long valor2) {
        try {
            return (double) valor1 / valor2;
        } catch (Exception e) {
            return 0;
        }
    }

    public static double divide(Integer valor1, Integer valor2) {
        try {
            return (double) valor1 / valor2;
        } catch (Exception e) {
            return 0;
        }
    }

    public static double divide(Double valor1, Double valor2) {
        try {
            return (double) valor1 / valor2;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void listarArchivosRecursivamente(List<File> listaArchivos, File f, String ruta) {
        File[] ficheros = f.listFiles();

        for (int x = 0; x < ficheros.length; x++) {
            if (ficheros[x].isDirectory()) {
                listarArchivosRecursivamente(listaArchivos, ficheros[x], ficheros[x].getAbsolutePath());
            } else {
                //listaArchivos.add(ruta+"/"+ficheros[x].getName().replace(" ",""));
                listaArchivos.add(ficheros[x]);
                System.out.println("");
            }
        }
    }

    public static void copyFile(File s, File t) {
        try {
            FileChannel in = (new FileInputStream(s)).getChannel();
            FileChannel out = (new FileOutputStream(t)).getChannel();
            in.transferTo(0, s.length(), out);
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
