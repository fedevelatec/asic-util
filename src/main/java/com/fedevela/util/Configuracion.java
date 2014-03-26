package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */
public class Configuracion {

    private String conexionAcceso, servidorAcceso, ownerAcceso, usuarioAcceso, passwordAcceso;
    private String conexionProduccion, servidorProduccion, ownerProduccion, usuarioProduccion, passwordProduccion;
    private String rutaImagen, host, sendMail, passwordSendMail;
    private String replySistemas, maquina;
    private String loteFacturasAvaluos;
    private String lotePeritosAvaluos;
    private int diasVigenciaConsulta;
    private int consultaFisica;
    private String rutaReportes, rutaTransferido, rutaLogs, rutaTransferidoAIG, rutaLogsAIG;
    private String rutaTransferidoGral;
    private String rutaTransferidoPensiones;
    private String rutaTransferidoLoreal;
    private String rutaTransferidoLfactoraje;
    private String rutaTransferidoPendulum;
    private String rutaTransferidoAvaluos;
    private String rutaTransferidoTelefonica;
    private String rutaTransferidoProveedores;
    private String rutaIntegracionesLoreal;
    private String rutaTransferidoIntegracionesLoreal;
    private String rutaLoreal;
    private String rutaLfactoraje;
    private String rutaPendulum;
    private String rutaPensiones;
    private String rutaSemarnat;
    private String rutaAvaluos;
    private String rutaAvaluosConsulta;
    private String rutaTelefonica;
    private String clientesRetornoGral;
    private String clientesRetornoEcu;
    private String clientesRetornoEtn;
    private String clientesCheckListDig;
    private String integracionImagenes;

    //Constructor por default
    public Configuracion() {
    }

    //Regresa el valor del atributo conexionAcceso
    public String getConexionAcceso() {
        if (conexionAcceso == null) {
            return "";
        } else {
            return conexionAcceso;
        }
    }

    //Asigna un valor al atributo conexionAcceso
    public void setConexionAcceso(String conexionAcceso) {
        this.conexionAcceso = conexionAcceso;
    }

    //Regresa el valor del atributo servidorAcceso
    public String getServidorAcceso() {
        if (servidorAcceso == null) {
            return "";
        } else {
            return servidorAcceso;
        }
    }

    //Asigna un valor al atributo servidorAcceso
    public void setServidorAcceso(String servidorAcceso) {
        this.servidorAcceso = servidorAcceso;
    }

    //Regresa el valor del atributo ownerAcceso
    public String getOwnerAcceso() {
        if (ownerAcceso == null) {
            return "";
        } else {
            return ownerAcceso;
        }
    }

    //Asigna un valor al atributo ownerAcceso
    public void setOwnerAcceso(String ownerAcceso) {
        this.ownerAcceso = ownerAcceso;
    }

    //Regresa el valor del atributo usuarioAcceso
    public String getUsuarioAcceso() {
        if (usuarioAcceso == null) {
            return "";
        } else {
            return usuarioAcceso;
        }
    }

    //Asigna un valor al atributo usuarioAcceso
    public void setUsuarioAcceso(String usuarioAcceso) {
        this.usuarioAcceso = usuarioAcceso;
    }

    //Regresa el valor del atributo passwordAcceso
    public String getPasswordAcceso() {
        if (passwordAcceso == null) {
            return "";
        } else {
            return passwordAcceso;
        }
    }

    //Asigna un valor al atributo passwordAcceso
    public void setPasswordAcceso(String passwordAcceso) {
        this.passwordAcceso = passwordAcceso;
    }

    //Regresa el valor del atributo conexionProduccion
    public String getConexionProduccion() {
        if (conexionProduccion == null) {
            return "";
        } else {
            return conexionProduccion;
        }
    }

    //Asigna el valor del atributo conexionProduccion
    public void setConexionProduccion(String conexionProduccion) {
        this.conexionProduccion = conexionProduccion;
    }

    //Regresa el valor del atributo servidorProducci�n
    public String getServidorProduccion() {
        return servidorProduccion;
    }

    //Asigna un valor al atributo servidorConexion
    public void setServidorProduccion(String servidorProduccion) {
        this.servidorProduccion = servidorProduccion;
    }

    //Regresa el valor del atributo ownerProduccion
    public String getOwnerProduccion() {
        if (ownerProduccion == null) {
            return "";
        } else {
            return ownerProduccion;
        }
    }

    //Asigna un valor al atributo ownerProduccion
    public void setOwnerProduccion(String ownerProduccion) {
        this.ownerProduccion = ownerProduccion;
    }

    //Regresa el valor del atributo usuarioProduccion
    public String getUsuarioProduccion() {
        if (usuarioProduccion == null) {
            return "";
        } else {
            return usuarioProduccion;
        }
    }

    //Asigna un valor al atributo usuarioProduccion
    public void setUsuarioProduccion(String usuarioProduccion) {
        this.usuarioProduccion = usuarioProduccion;
    }

    //Regresa el valor del atributo passwordProduccion
    public String getPasswordProduccion() {
        if (passwordProduccion == null) {
            return "";
        } else {
            return passwordProduccion;
        }
    }

    //Asigna un valor al atributo passwordProduccion
    public void setPasswordProduccion(String passwordProduccion) {
        this.passwordProduccion = passwordProduccion;
    }

    //Regresa el valor del atributo rutaImagen
    public String getRutaImagen() {
        if (rutaImagen == null) {
            return "";
        } else {
            return rutaImagen;
        }
    }

    //Asigna un valor al atributo rutaImagen
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    //Regresa el valor del atributo host
    public String getHost() {
        if (host == null) {
            return "";
        } else {
            return host;
        }
    }

    //Asigna un valor al atributo host
    public void setHost(String host) {
        this.host = host;
    }

    //Regresa el valor del atributo sendMail
    public String getSendMail() {
        if (sendMail == null) {
            return "";
        } else {
            return sendMail;
        }
    }

    //Asigna un valor al atributo sendMail
    public void setSendMail(String sendMail) {
        this.sendMail = sendMail;
    }

    //Regresa el valor del atributo passwordSendMail
    public String getPasswordSendMail() {
        if (passwordSendMail == null) {
            return "";
        } else {
            return passwordSendMail;
        }
    }

    //Asigna un valor al atributo passwordSendMail
    public void setPasswordSendMail(String passwordSendMail) {
        this.passwordSendMail = passwordSendMail;
    }

    //Regresa el valor del atributo replySistemas
    public String getReplySistemas() {
        if (replySistemas == null) {
            return "";
        } else {
            return replySistemas;
        }
    }

    //Asigna un valor al atributo replySistemas
    public void setReplySistemas(String replySistemas) {
        this.replySistemas = replySistemas;
    }

    //Regresa el valor de atributo diasVigenciaConsulta
    public int getDiasVigenciaConsulta() {
        return diasVigenciaConsulta;
    }

    //Asigna un valor al atributo diasVigenciaConsulta
    public void setDiasVigenciaConsulta(int diasVigenciaConsulta) {
        this.diasVigenciaConsulta = diasVigenciaConsulta;
    }

    //Regresa el valor del atributo consultaFisica
    public int getConsultaFisica() {
        return consultaFisica;
    }

    //Asigna un valor al atributo consultaFisica
    public void setConsultaFisica(int consultaFisica) {
        this.consultaFisica = consultaFisica;
    }

    //Regresa el valor del atributo rutaReportes
    public String getRutaReportes() {
        if (rutaReportes == null) {
            return "";
        } else {
            return rutaReportes;
        }
    }

    //Asigna un valor al atributo rutaReportes
    public void setRutaReportes(String ruta_reportes) {
        this.rutaReportes = ruta_reportes;
    }

    //Regresa el valor del atributo rutaTransferido
    public String getRutaTransferido() {
        if (rutaTransferido == null) {
            return "";
        } else {
            return rutaTransferido;
        }
    }

    //Asigna un valor al atributo rutaTransferido
    public void setRutaTransferido(String rutaTransferido) {
        this.rutaTransferido = rutaTransferido;
    }

    //Regresa el valor del atributo rutaLogs
    public String getRutaLogs() {
        if (rutaLogs == null) {
            return "";
        } else {
            return rutaLogs;
        }
    }

    //Asigna un valor al atributo rutaLogs
    public void setRutaLogs(String rutaLogs) {
        this.rutaLogs = rutaLogs;
    }

    //Regresa el valor del atributo maquina
    public String getMaquina() {
        return maquina;
    }

    //Asigna un valor al aributo maquina
    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getLoteFacturasAvaluos() {
        return loteFacturasAvaluos;
    }

    public void setLoteFacturasAvaluos(String loteFacturasAvaluos) {
        this.loteFacturasAvaluos = loteFacturasAvaluos;
    }

    public String getLotePeritosAvaluos() {
        return lotePeritosAvaluos;
    }

    public void setLotePeritosAvaluos(String lotePeritosAvaluos) {
        this.lotePeritosAvaluos = lotePeritosAvaluos;
    }

    public String getRutaTransferidoAIG() {
        return rutaTransferidoAIG;
    }

    public void setRutaTransferidoAIG(String rutaTransferidoAIG) {
        this.rutaTransferidoAIG = rutaTransferidoAIG;
    }

    public String getRutaLogsAIG() {
        return rutaLogsAIG;
    }

    public void setRutaLogsAIG(String rutaLogsAIG) {
        this.rutaLogsAIG = rutaLogsAIG;
    }

    public String getRutaTransferidoLoreal() {
        return rutaTransferidoLoreal;
    }

    public void setRutaTransferidoLoreal(String rutaTransferidoLoreal) {
        this.rutaTransferidoLoreal = rutaTransferidoLoreal;
    }

    public String getRutaTransferidoLfactoraje() {
        return rutaTransferidoLfactoraje;
    }

    public void setRutaTransferidoLfactoraje(String rutaTransferidoLfactoraje) {
        this.rutaTransferidoLfactoraje = rutaTransferidoLfactoraje;
    }

    public String getRutaLfactoraje() {
        return rutaLfactoraje;
    }

    public void setRutaLfactoraje(String rutaLfactoraje) {
        this.rutaLfactoraje = rutaLfactoraje;
    }

    public String getRutaLoreal() {
        return rutaLoreal;
    }

    public void setRutaLoreal(String rutaLoreal) {
        this.rutaLoreal = rutaLoreal;
    }

    public String getRutaTransferidoPendulum() {
        return rutaTransferidoPendulum;
    }

    public void setRutaTransferidoPendulum(String rutaTransferidoPendulum) {
        this.rutaTransferidoPendulum = rutaTransferidoPendulum;
    }

    public String getRutaPendulum() {
        return rutaPendulum;
    }

    public void setRutaPendulum(String rutaPendulum) {
        this.rutaPendulum = rutaPendulum;
    }

    public String getClientesRetornoGral() {
        return clientesRetornoGral;
    }

    public void setClientesRetornoGral(String clientesRetornoGral) {
        this.clientesRetornoGral = clientesRetornoGral;
    }

    public String getClientesRetornoEcu() {
        return clientesRetornoEcu;
    }

    public void setClientesRetornoEcu(String clientesRetornoEcu) {
        this.clientesRetornoEcu = clientesRetornoEcu;
    }

    public String getRutaTransferidoGral() {
        return rutaTransferidoGral;
    }

    public void setRutaTransferidoGral(String rutaTransferidoGral) {
        this.rutaTransferidoGral = rutaTransferidoGral;
    }

    public String getRutaPensiones() {
        return rutaPensiones;
    }

    public void setRutaPensiones(String rutaPensiones) {
        this.rutaPensiones = rutaPensiones;
    }

    public String getIntegracionImagenes() {
        return integracionImagenes;
    }

    public void setIntegracionImagenes(String integracionImagenes) {
        this.integracionImagenes = integracionImagenes;
    }

    public String getRutaTransferidoAvaluos() {
        return rutaTransferidoAvaluos;
    }

    public void setRutaTransferidoAvaluos(String rutaTransferidoAvaluos) {
        this.rutaTransferidoAvaluos = rutaTransferidoAvaluos;
    }

    public String getRutaTransferidoTelefonica() {
        return rutaTransferidoTelefonica;
    }

    public void setRutaTransferidoTelefonica(String rutaTransferidoTelefonica) {
        this.rutaTransferidoTelefonica = rutaTransferidoTelefonica;
    }

    public String getRutaAvaluos() {
        return rutaAvaluos;
    }

    public void setRutaAvaluos(String rutaAvaluos) {
        this.rutaAvaluos = rutaAvaluos;
    }

    public String getRutaAvaluosConsulta() {
        return rutaAvaluosConsulta;
    }

    public void setRutaAvaluosConsulta(String rutaAvaluosConsulta) {
        this.rutaAvaluosConsulta = rutaAvaluosConsulta;
    }

    public String getRutaTelefonica() {
        return rutaTelefonica;
    }

    public void setRutaTelefonica(String rutaTelefonica) {
        this.rutaTelefonica = rutaTelefonica;
    }

    public String getRutaSemarnat() {
        return rutaSemarnat;
    }

    public void setRutaSemarnat(String rutaSemarnat) {
        this.rutaSemarnat = rutaSemarnat;
    }

    public String getClientesCheckListDig() {
        return clientesCheckListDig;
    }

    public void setClientesCheckListDig(String clientesCheckListDig) {
        this.clientesCheckListDig = clientesCheckListDig;
    }

    public String getRutaIntegracionesLoreal() {
        return rutaIntegracionesLoreal;
    }

    public void setRutaIntegracionesLoreal(String rutaIntegracionesLoreal) {
        this.rutaIntegracionesLoreal = rutaIntegracionesLoreal;
    }

    public String getRutaTransferidoIntegracionesLoreal() {
        return rutaTransferidoIntegracionesLoreal;
    }

    public void setRutaTransferidoIntegracionesLoreal(String rutaTransferidoIntegracionesLoreal) {
        this.rutaTransferidoIntegracionesLoreal = rutaTransferidoIntegracionesLoreal;
    }

    public String getRutaTransferidoPensiones() {
        return rutaTransferidoPensiones;
    }

    public void setRutaTransferidoPensiones(String rutaTransferidoPensiones) {
        this.rutaTransferidoPensiones = rutaTransferidoPensiones;
    }

    /**
     * @return the clientesRetornoEtn
     */
    public String getClientesRetornoEtn() {
        return clientesRetornoEtn;
    }

    /**
     * @param clientesRetornoEtn the clientesRetornoEtn to set
     */
    public void setClientesRetornoEtn(String clientesRetornoEtn) {
        this.clientesRetornoEtn = clientesRetornoEtn;
    }

    public String getRutaTransferidoProveedores() {
        return rutaTransferidoProveedores;
    }

    public void setRutaTransferidoProveedores(String rutaTransferidoProveedores) {
        this.rutaTransferidoProveedores = rutaTransferidoProveedores;
    }

}
