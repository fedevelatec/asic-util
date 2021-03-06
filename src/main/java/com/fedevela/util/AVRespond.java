package com.fedevela.util;

import java.io.File;
import java.io.FileOutputStream;
/**
 * Created by fvelazquez on 26/03/14.
 */
public class AVRespond {
    public static final String one = "ICAP/1.0 100";
    public static final String two = "ICAP/1.0 200";
    public static final String three = "ICAP/1.0 201";
    public static final String four = "ICAP/1.0 204";
    public static final String five = "ICAP/1.0 400";
    public static final String six = "ICAP/1.0 403";
    public static final String seven = "ICAP/1.0 404";
    public static final String eight = "ICAP/1.0 405";
    public static final String nine = "ICAP/1.0 408";
    public static final String ten = "ICAP/1.0 500";
    public static final String eleven = "ICAP/1.0 503";
    public static final String twelve = "ICAP/1.0 505";
    public static final String thirteen = "ICAP/1.0 533";
    public static final String fourteen = "ICAP/1.0 539";
    public static final String fifteen = "ICAP/1.0 551";
    public static final String sixteen = "ICAP/1.0 558";

    protected byte[] bytes;

    public AVRespond() {
    }

    public boolean continue_check(String server_response) {
        boolean the_return = true;
        if ((server_response.length()) != 12) {
            server_response = server_response.substring(0, 12);
        }

        if (server_response.equals(one)) {
            the_return = true;
        }
        else {
            the_return = false;
        }

        return the_return;
    }

    public String request(String server_response) {
        String the_return = " ";
        if ((server_response.length()) != 12) {
            server_response = server_response.substring(0, 12);
        }

        if (server_response.equals(fourteen) || server_response.equals(sixteen)) {
            the_return = "clean";
            String body = "Note the license for Symantec Scan Engine is invalid or has expired!\n\rPlease see CGS Template code - class AVRespond for more info.\n\rThis email is sent every time a client uploads an un-scanned file";
            try {
                //EmailUtility.SendMail("symantec_scan_engine@standardandpoors.com", "wdcalarm@standardandpoors.com", "Invalid or expired license for Symantec Scan Engine", body);
            }
            catch (Exception ex) {
                System.out.println("AV client could not send email notification\nMake sure sp.properties has \"mail.smtp.host=smtprelay.mhf2.mhf.mhc\" entry in it \n " + ex);
            }
        }

        if (server_response.equals(four)) {
            the_return = "clean";
        }

        if (server_response.equals(two)) {
            the_return = "virus";
        }

        if (server_response.equals(three)) {
            the_return = "virus";
        }

        return the_return;
    }

    public void create_file(String message, String newfile) {
        bytes = message.getBytes();
        int i = 0;
        boolean result = false;
        try {
            File file = new File(newfile);
            result = file.createNewFile();
            FileOutputStream output = new FileOutputStream(newfile);
            output.write(bytes);
        }
        catch (Exception ex) {
            System.out.println("AV clinet could not create output file: "+ex);
        }
    }
}
