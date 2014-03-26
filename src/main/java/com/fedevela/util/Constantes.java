package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */
public class Constantes {

    public static final String meses[] = {"Default","Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

    public static final  String tablasReporteGlobal[] = {"drubio.activos_metro","drubio.activos_foraneo","drubio.activos_lope_de_vega","drubio.jubilados"};

    public static final  String PROCEDIMIENTO1 = Util.buildProcedureCall("PROD.pkg_vtm_genera_reporte_rh", "sp_generar_reporte", 3);

    public static final String CLIENTES_REPORTE_TIPO_FISCAL1[] = {"ACCIVAL","BANAMEX","BANAMEX",
            "Bancomer Jubilados","Empleados y Funcionarios de Bancomer Operadora",
            "VITAMEDICA","Empleados de ATA BBVA"};

    public static final String CLIENTES_REPORTE_TIPO_FISCAL1_PROCEDIMIENTO[] = {"ACCIVAL","BANAMEX","BANCOMER","VITAMEDICA"};

    public static final String CLIENTES_RECETAS[] = {"BANAMEX","BANCOMER","BANCOMER JUBILADOS"};

    public static final String NUMEROS[] = {"0","1","2","3","4","5","6","7","8","9","."};

    public static final String CLIENTES_ECC[] = {"OTRO","BANAMEX","ACCIVAL","BBVA BANCOMER","BANCOMER OPERADORA","VITAMEDICA","ATA BBVA"};

    //Tipos de documentos
    public static final int FACETS = 1;
    public static final int FARMACIA = 2;
    public static final int RECIBO_HONORARIO = 3;
    public static final int ESTADISTICOS = 4;
    public static final int CAPITAS_SIN_FACTURA = 5;

    //BMRJUB  jubilados
    //13000006 operadora
    //13000043 ATA
    public static final String grupoCapitasJubilados = "BMRJUB";
    public static final String grupoCapitasOperadora = "13000006";
    public static final String grupoCapitasEma = "EMABMER";
    public static final String grupoCapitasATA = "13000043";


    //Generacion de disco PDN
    public static final String cabeceraHTML = "<HTML> <table width='950' align='center' border='0' cellspacing='0' cellpadding='0'> "+
            "<tr> "+
            "<td> "+
            "<img src='images/logo.jpg' height='80' width='150' alt='AdeA México' border='no'> "+
            "</td> "+
            "<td bgcolor='white' height='80' valign='middle' width='650' align='center'> "+
            "<B><font face='Verdana' size='3' color='Navy'>DIGITALIZACION PORTAFOLIO DE NEGOCIOS</font></B> "+
            "</td> "+
            "<td align='right' height='30' width='150' valign='middle'> "+
            "<a href='http://www.adea.com.mx'><img src='images/LogoAplicacion.gif' border='0' height='25' width='125'></a> "+
            "</td> "+
            "</tr> "+
            "<tr> "+
            "<td colspan='6' height='30' width='950' valign='bottom'> "+
            "<img src='images/Barra.gif' height='4' width='950'> "+
            "</td> "+
            "</tr> "+
            "</table> "+
            "<table width='950' align='center' border='1' cellspacing='0' cellpadding='0'> "+
            "<tr> "+
            "<td align='center' valign='middle' bgColor='Navy' height='20' width='80' > "+
            "<font face='Verdana' size='1' color='white'><B>CODIGO<br>EXPEDIENTE</B></font></td> "+
            "<td align='center' valign='middle' bgColor='Navy' height='20' width='80'> "+
            "<font face='Verdana' size='1' color='white'><B>CODIGO<br>DOCUMENTO</B></font></td> "+
            "<td align='center' valign='middle' bgColor='Navy' height='20' width='60'> "+
            "<font face='Verdana' size='1' color='white'><B>NO<br>CLIENTE</B></font></td> "+
            "<td align='center' valign='middle' bgColor='Navy' height='20' width='350'> "+
            "<font face='Verdana' size='1' color='white'><B>NOMBRE</B></font></td> "+
            "<td align='center' valign='middle' bgColor='Navy' height='20' width='200'> "+
            "<font face='Verdana' size='1' color='white'><B>DOCUMENTO</B></font></td> "+
            "<td align='center' valign='middle' bgColor='Navy' height='20' width='160'> "+
            "<font face='Verdana' size='1' color='white'><B>IMAGENES</B></font></td> "+
            "</tr>";

    public static final String pieHTML = "</table> </HTML> ";
}

