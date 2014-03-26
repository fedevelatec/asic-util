package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */


import java.io.InputStream;
import org.apache.commons.digester.Digester;

public class CargarConfiguracion {

    private String xml;
    private Configuracion configuracion;

    //Constructor
    public CargarConfiguracion() {
    }

    //Regresa el valor del atributo configuracion
    public Configuracion getConfiguracion(InputStream is) throws Exception {
        try {
            Digester digester = new Digester();
            digester.setValidating(false);
            digester.push(this);
            digester.addObjectCreate("configuracion", Configuracion.class);
            digester.addBeanPropertySetter("configuracion/conexionAcceso", "conexionAcceso");
            digester.addBeanPropertySetter("configuracion/servidorAcceso", "servidorAcceso");
            digester.addBeanPropertySetter("configuracion/ownerAcceso", "ownerAcceso");
            digester.addBeanPropertySetter("configuracion/usuarioAcceso", "usuarioAcceso");
            digester.addBeanPropertySetter("configuracion/passwordAcceso", "passwordAcceso");

            digester.addBeanPropertySetter("configuracion/conexionProduccion", "conexionProduccion");
            digester.addBeanPropertySetter("configuracion/servidorProduccion", "servidorProduccion");
            digester.addBeanPropertySetter("configuracion/ownerProduccion", "ownerProduccion");
            digester.addBeanPropertySetter("configuracion/usuarioProduccion", "usuarioProduccion");
            digester.addBeanPropertySetter("configuracion/passwordProduccion", "passwordProduccion");

            digester.addBeanPropertySetter("configuracion/rutaImagen", "rutaImagen");
            digester.addBeanPropertySetter("configuracion/host", "host");
            digester.addBeanPropertySetter("configuracion/sendMail", "sendMail");
            digester.addBeanPropertySetter("configuracion/passwordSendMail", "passwordSendMail");
            digester.addBeanPropertySetter("configuracion/replySistemas", "replySistemas");
            digester.addBeanPropertySetter("configuracion/diasVigenciaConsulta", "diasVigenciaConsulta");
            digester.addBeanPropertySetter("configuracion/consultaFisica", "consultaFisica");
            digester.addBeanPropertySetter("configuracion/rutaReportes", "rutaReportes");
            digester.addBeanPropertySetter("configuracion/rutaTransferido", "rutaTransferido");
            digester.addBeanPropertySetter("configuracion/rutaTransferidoAIG", "rutaTransferidoAIG");
            digester.addBeanPropertySetter("configuracion/rutaLogs", "rutaLogs");
            digester.addBeanPropertySetter("configuracion/rutaLogsAIG", "rutaLogsAIG");

            digester.addBeanPropertySetter("configuracion/loteFacturasAvaluos", "loteFacturasAvaluos");
            digester.addBeanPropertySetter("configuracion/lotePeritosAvaluos", "lotePeritosAvaluos");

            digester.addBeanPropertySetter("configuracion/rutaTransferidoLoreal", "rutaTransferidoLoreal");
            digester.addBeanPropertySetter("configuracion/rutaTransferidoLfactoraje", "rutaTransferidoLfactoraje");
            digester.addBeanPropertySetter("configuracion/rutaTransferidoPendulum", "rutaTransferidoPendulum");
            digester.addBeanPropertySetter("configuracion/rutaTransferidoTelefonica", "rutaTransferidoTelefonica");
            digester.addBeanPropertySetter("configuracion/rutaTransferidoAvaluos", "rutaTransferidoAvaluos");
            digester.addBeanPropertySetter("configuracion/rutaTransferidoProveedores", "rutaTransferidoProveedores");

            digester.addBeanPropertySetter("configuracion/rutaLoreal", "rutaLoreal");
            digester.addBeanPropertySetter("configuracion/rutaLfactoraje", "rutaLfactoraje");
            digester.addBeanPropertySetter("configuracion/rutaPendulum", "rutaPendulum");
            digester.addBeanPropertySetter("configuracion/rutaPensiones", "rutaPensiones");
            digester.addBeanPropertySetter("configuracion/rutaSemarnat", "rutaSemarnat");
            digester.addBeanPropertySetter("configuracion/rutaAvaluos", "rutaAvaluos");
            digester.addBeanPropertySetter("configuracion/rutaAvaluosConsulta", "rutaAvaluosConsulta");
            digester.addBeanPropertySetter("configuracion/rutaTelefonica", "rutaTelefonica");

            digester.addBeanPropertySetter("configuracion/rutaIntegracionesLoreal", "rutaIntegracionesLoreal");
            digester.addBeanPropertySetter("configuracion/rutaTransferidoIntegracionesLoreal", "rutaTransferidoIntegracionesLoreal");

            digester.addBeanPropertySetter("configuracion/clientesRetornoGral", "clientesRetornoGral");
            digester.addBeanPropertySetter("configuracion/clientesRetornoEcu", "clientesRetornoEcu");
            digester.addBeanPropertySetter("configuracion/clientesRetornoEtn", "clientesRetornoEtn");
            digester.addBeanPropertySetter("configuracion/clientesCheckListDig", "clientesCheckListDig");
            digester.addBeanPropertySetter("configuracion/maquina", "maquina");
            digester.addBeanPropertySetter("configuracion/rutaTransferidoGral", "rutaTransferidoGral");
            digester.addBeanPropertySetter("configuracion/integracionImagenes", "integracionImagenes");
            digester.addSetNext("configuracion", "setConfiguracion");

            CargarConfiguracion ds = (CargarConfiguracion) digester.parse(is);

            return configuracion;
        } catch (Exception e) {
            e.printStackTrace();
            configuracion = null;
            Log.getLogger().severe(e.getMessage());
            throw new Exception();
        }
    }

    //Asigna un valor al atributo configuracion
    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }

    //Regresa el valor del atributo xml
    public String getXml() {
        if (xml == null) {
            return "";
        } else {
            return xml;
        }
    }

    //Asigna un valor al atributo xml
    public void setXml(String xml) {
        this.xml = xml;
    }
}
