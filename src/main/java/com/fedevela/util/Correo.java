package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Correo {
    private String host, to, from, cc, bcc, asunto, msg;
    private String formato;


    //Constructor por default
    public Correo() {
    }


    //Clase interna para la autentificaci�n del usuario y password
    class SMTPAuthentication extends Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            String usuario = "mailroom@adea.com.mx";
            String password = "adea882004";
            return new PasswordAuthentication(usuario, password);
        }
    }


    //Constructor que recibe como par�metros valores para los atributos que integran la clase
    public Correo(String host, String to, String from, String cc, String bcc,
                  String asunto, String msg, String formato) throws Exception {
        try {
            this.host = host;
            this.to = to;
            this.from = from;
            this.cc = cc;
            this.bcc = bcc;
            this.asunto = asunto;
            this.msg = msg;
            this.formato = formato;
        }
        catch(Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }


    //Envia el mensaje v�a un servidor de correo SMTP
    public void enviarCorreo() throws Exception {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.auth", "false");

            SMTPAuthentication auth = new SMTPAuthentication();
            Session sesion = Session.getInstance(props, auth);
            Message mensaje = new MimeMessage(sesion);
            InternetAddress FROM = new InternetAddress(from);
            mensaje.setFrom(FROM);
            InternetAddress[] TO = {new InternetAddress(to)};
            mensaje.setRecipients(Message.RecipientType.TO, TO);
            InternetAddress[] CC = {new InternetAddress(cc)};
            mensaje.setRecipients(Message.RecipientType.CC, CC);
            InternetAddress[] BCC = {new InternetAddress(bcc)};
            mensaje.setRecipients(Message.RecipientType.BCC, BCC);
            mensaje.setSubject(asunto);
            mensaje.setContent(msg, formato);
            Transport.send(mensaje);
        }
        catch(Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }
}
