package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtils {

    public static byte[] getBytes(File file) throws IOException {

        InputStream is = new FileInputStream(file);

        long length = file.length();

        if (length > Integer.MAX_VALUE) {

        }

        byte[] bytes = new byte[(int)length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }

        is.close();
        return bytes;
    }

    public String getPc() {
        return System.getenv("COMPUTERNAME");
    }

    public String getIp() {
        String ip = "";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ip;
    }

}

