package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */
import java.text.SimpleDateFormat;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


public class Log {
    private static Logger logger;


    //Constructor
    public Log() throws Exception {
        try {
            //FileHandler fh = new FileHandler("T:\\logs\\CargarConsulta.log", true);
            //fh.setFormatter(new Formato());
            logger = Logger.getLogger("CargarConsulta");
            //logger.addHandler(fh);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    //Regresa el valor del atributo logger
    public static Logger getLogger() {
        return logger;
    }


    //Asigna un valor al atributo logger
    public static void setLogger(Logger aLogger) {
        logger = aLogger;
    }


    //Clase para formatear la salida del archivo log
    class Formato extends Formatter {
        public String format(LogRecord record) {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            StringBuffer buf = new StringBuffer(1000);
            buf.append(formato.format(new java.util.Date()));
            buf.append(' ');
            buf.append(record.getLevel());
            buf.append(' ');
            buf.append(formatMessage(record));
            buf.append(System.getProperty("line.separator"));
            return buf.toString();
        }
    }
}



