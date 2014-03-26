package com.fedevela.util;

/**
 * Created by fvelazquez on 26/03/14.
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class AVClient {
    private String servername = "201.134.153.190";
    private int port = 1344;
    private String scanpolicy = "SCAN";
    private String filename = "";
    private String outputfilename;

    private Socket socket = null;
    private DataOutputStream output = null;
    private BufferedReader input = null;

    protected byte[] bytes;

    private String[] results;

    protected int allow = 204;

    public AVClient() {
    }

    public AVClient(String server_name, int the_port, String scan_policy) {
        servername = server_name;
        port = the_port;
        scanpolicy = scan_policy;
    }

    public int setparams(String server_name, int the_port, String scan_policy) {
        servername = server_name;
        port = the_port;
        scanpolicy = scan_policy;
        return (0);
    }

    public int test() {
        int return_value = 0;
        if ((servername.length()) < 7 || (servername.length()) > 16) {
            return_value = 1;
        }

        if (port < 1 || port > 8000) {
            return_value = 1;
        }

        if (return_value == 0 && socket == null) {
            return_value = connect(servername);
            disconnect();
        }

        return (return_value);
    }

    public int optionscheck() {
        int the_return = 0;
        String message = "OPTIONS icap://" + servername + ":" + port + "/avscan ICAP/1.0 \r\n" + "Host " + servername + " \r\n" + "\r\n";
        the_return = connect(servername);
        if (the_return == 0) {
            the_return = send(message);
        }

        return the_return;
    }

    public int scanfile(String file_name) {
        filename = file_name;
        int the_return = 0;
        long file_length = 0;
        long long_length = 4;
        String server_message = "";

        try {
            File file = new File(file_name);
            InputStream is = new FileInputStream(file);
            file_length = file.length();
            if (file_length < 1) {
                the_return = 1;
            }
            else if (file_length > 1 && (file_length > Integer.MAX_VALUE)) {
                the_return = 1;
            }
        }
        catch (Exception e) {
            the_return = 1;
        }

        the_return = connect(servername);
        AVRespond check_response = new AVRespond();

        while (the_return == 0) {
            int req_header = 0;
            int res_header;
            int res_body;

            String reqheader = "GET http://scapi.symantec.com" + "/" + file_name + " HTTP/1.1\r\n" + "Host: scapi.symantec.com\r\n" + "\r\n";
            String resheader = "HTTP/1.1 200 OK\r\n" + "Transfer-Encoding: chunked\r\n" + "\r\n";
            res_header = reqheader.length();
            res_body = res_header + (resheader.length());
            String header = "RESPMOD icap://" + servername + ":" + port + "/AVSCAN?action=" + scanpolicy + " ICAP/1.0\r\n" + "Host: " + servername + ":" + port + "\r\n" + "Preview: 4" + "\r\n" + "Allow: " +
                    allow + "\r\n" + "Encapsulated: req-hdr=" + req_header + " res-hdr=" + res_header + " res-body=" +
                    res_body + "\r\n" + "\r\n";
            the_return = send(header);
            if (the_return == 1) {
                break;
            }

            the_return = send(reqheader);
            if (the_return == 1) {
                break;
            }

            the_return = send(resheader);
            if (the_return == 1) {
                break;
            }

            byte[] b = convert();
            header = "";
            try {
                header = Long.toHexString(long_length);
                header = header + "\r\n";
                the_return = send(header);
                if (the_return == 1) {
                    break;
                }

                header = "\r\n" + "0" + "\r\n" + "\r\n";
                output.write(b, 0, 4);
                the_return = send(header);
                if (the_return == 1) {
                    break;
                }

            }
            catch (Exception e) {
                e.printStackTrace();
            }

            header = "";
            header = recieve();
            if ((check_response.continue_check(header)) == true) {
                file_length = file_length - 4;
                header = Long.toHexString(file_length);
                header = header + "\r\n";
                try {
                    the_return = send(header);
                    if (the_return == 1) {
                        break;
                    }

                    output.write(b, 4, ( (int) file_length));
                    the_return = send("\r\n0\r\n\r\n");
                    if (the_return == 1) {
                        break;
                    }

                    header = "";
                    header = recieve();
                    server_message = header.substring(0, 12);
                    server_message = check_response.request(server_message);
                }
                catch (Exception e) {
                    the_return = 1;
                }
            }
            else {
                the_return = 1;
            }

            disconnect();
            break;
        }

        if (the_return != 1) {
            if (server_message.equals("virus")) {
                the_return = -1;
            }

            if (server_message.equals("clean")) {
                the_return = 0;
            }
        }

        return (the_return);
    }

    public int scanfile(String file_name, String outputfile_name) {
        filename = file_name;
        outputfilename = outputfile_name;
        int the_return = 0;
        long file_length = 0;
        long long_length = 4;
        String server_message = "";
        String header = "";
        String text = "";

        try {
            File file = new File(file_name);
            InputStream is = new FileInputStream(file);
            file_length = file.length();
            if (file_length < 1) {
                the_return = 1;
            }
            else if (file_length > 1 && (file_length > Integer.MAX_VALUE)) {
                the_return = 1;
            }
        }
        catch (Exception e) {
            the_return = 1;
        }

        the_return = connect(servername);
        AVRespond check_response = new AVRespond();

        while (the_return == 0) {
            int req_header = 0;
            int res_header;
            int res_body;

            String reqheader = "GET http://scapi.symantec.com" + "/" + file_name + " HTTP/1.1\r\n" + "Host: scapi.symantec.com\r\n" + "\r\n";
            String resheader = "HTTP/1.1 200 OK\r\n" + "Transfer-Encoding: chunked\r\n" + "\r\n";
            res_header = reqheader.length();
            res_body = res_header + (resheader.length());
            header = "RESPMOD icap://" + servername + ":" + port + "/AVSCAN?action=" + scanpolicy + " ICAP/1.0\r\n" + "Host: " + servername + ":" + port + "\r\n" + "Preview: 4" + "\r\n" + "Allow: " + allow +
                    "\r\n" + "Encapsulated: req-hdr=" + req_header + " res-hdr=" + res_header + " res-body=" +
                    res_body + "\r\n" + "\r\n";
            the_return = send(header);
            if (the_return == 1) {
                break;
            }

            the_return = send(reqheader);
            if (the_return == 1) {
                break;
            }

            the_return = send(resheader);
            if (the_return == 1) {
                break;
            }

            byte[] b = convert();
            header = "";
            try {
                header = Long.toHexString(long_length);
                header = header + "\r\n";
                the_return = send(header);
                if (the_return == 1) {
                    break;
                }

                header = "\r\n" + "0" + "\r\n" + "\r\n";
                output.write(b, 0, 4);
                the_return = send(header);
                if (the_return == 1) {
                    break;
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            header = "";
            header = recieve();
            if ((check_response.continue_check(header)) == true) {
                file_length = file_length - 4;
                header = Long.toHexString(file_length);
                header = header + "\r\n";
                try {
                    the_return = send(header);
                    if (the_return == 1) {
                        break;
                    }

                    output.write(b, 4, ( (int) file_length));
                    the_return = send("\r\n0\r\n\r\n");
                    if (the_return == 1) {
                        break;
                    }

                    header = "";
                    header = recieve();
                    server_message = header.substring(0, 12);
                    server_message = check_response.request(server_message);
                    if (server_message.equals("virus")) {
                        header = header + recieve();
                        text = recieve();
                        header = header + text;
                    }
                }
                catch (Exception e) {
                    the_return = 1;
                }
            }
            else {
                the_return = 1;
            }

            disconnect();
            break;
        }

        if (the_return != 1) {
            if (server_message.equals("virus")) {
                the_return = -1;
            }

            if (server_message.equals("clean")) {
                the_return = 0;
            }
        }

        if (the_return == -1 && scanpolicy.equals("SCANREPAIRDELETE")) {
            check_response.create_file(text, outputfilename);
        }

        return (the_return);
    }

    public int scanfile(String file_name, byte[] b) {
        int the_return = 0;
        long file_length = b.length;
        long long_length = 4;
        String server_message = "";
        String header = "";
        String text = "";

        the_return = connect(servername);
        AVRespond check_response = new AVRespond();

        while (the_return == 0) {
            int req_header = 0;
            int res_header;
            int res_body;

            String reqheader = "GET http://scapi.symantec.com" + "/" + file_name + " HTTP/1.1\r\n" + "Host: scapi.symantec.com\r\n" + "\r\n";
            String resheader = "HTTP/1.1 200 OK\r\n" + "Transfer-Encoding: chunked\r\n" + "\r\n";
            res_header = reqheader.length();
            res_body = res_header + (resheader.length());
            header = "RESPMOD icap://" + servername + ":" + port + "/AVSCAN?action=" + scanpolicy + " ICAP/1.0\r\n" + "Host: " + servername + ":" + port + "\r\n" + "Preview: 4" + "\r\n" + "Allow: " + allow +
                    "\r\n" + "Encapsulated: req-hdr=" + req_header + " res-hdr=" + res_header + " res-body=" +
                    res_body + "\r\n" + "\r\n";
            the_return = send(header);
            if (the_return == 1) {
                break;
            }

            the_return = send(reqheader);
            if (the_return == 1) {
                break;
            }

            the_return = send(resheader);
            if (the_return == 1) {
                break;
            }

            header = "";
            try {
                header = Long.toHexString(long_length);
                header = header + "\r\n";
                the_return = send(header);
                if (the_return == 1) {
                    break;
                }

                header = "\r\n" + "0" + "\r\n" + "\r\n";
                output.write(b, 0, 4);
                the_return = send(header);
                if (the_return == 1) {
                    break;
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            header = "";
            header = recieve();
            if ((check_response.continue_check(header)) == true) {
                file_length = file_length - 4;
                header = Long.toHexString(file_length);
                header = header + "\r\n";
                try {
                    the_return = send(header);
                    if (the_return == 1) {
                        break;
                    }

                    output.write(b, 4, ( (int) file_length));
                    the_return = send("\r\n0\r\n\r\n");
                    if (the_return == 1) {
                        break;
                    }

                    header = "";
                    header = recieve();
                    server_message = header.substring(0, 12);
                    server_message = check_response.request(server_message);
                    if (server_message.equals("virus")) {
                        header = header + recieve();
                        text = recieve();
                        header = header + text;
                    }
                }
                catch (Exception e) {
                    the_return = 1;
                }
            }
            else {
                the_return = 1;
            }

            disconnect();
            break;
        }

        if (the_return != 1) {
            if (server_message.equals("virus")) {
                the_return = -1;
            }

            if (server_message.equals("clean")) {
                the_return = 0;
            }
        }

        return (the_return);
    }

    private int connect(String host) {
        int response = 0;
        if (socket == null) {
            try {
                InetAddress ip_address = InetAddress.getByName(host);
                socket = new Socket(host, port);
                output = new DataOutputStream(socket.getOutputStream());
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            }
            catch (Exception e) {
                response = 1;
                String body = "WARNING! Symantec Scan Engine could not be contacted! \n\rUsing \n\rhost: " + host + "\n\rport: " + port +
                        " \n\rFiles will be saved without virus scan ";
                System.out.println("Error de conexion: " + body);
            }
        }

        return response;
    }

    private int send(String str) {
        int response = 0;
        try {
            output.writeBytes(str);
            output.flush();
        }
        catch (Exception e) {
            response = 1;
        }

        return response;
    }

    private void disconnect() {
        try {
            input.close();
            output.close();
            socket.close();
            socket = null;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] convert() {
        long a_length = 0;

        try {
            File file = new File(filename);
            InputStream is = new FileInputStream(file);
            a_length = file.length();
            bytes = new byte[ (int) a_length];

            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }

            if (offset < bytes.length) {
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return bytes;
    }

    private String recieve() {
        String value = "  ";
        String the_message = new String();
        results = new String[512];
        int array_location = 0;

        try {
            while (value.length() != 0) {
                value = input.readLine();
                the_message = the_message + value + "\n";
                results[array_location] = value;
                array_location++;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return the_message;
    }
}
