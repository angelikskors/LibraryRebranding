package sample.utils;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class JavaMail {

    static PrintStream ps = null;          // ������� ���������
    static DataInputStream dis = null;     // ��������� ���������

    public JavaMail(String name, String mailFrom, String message) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                String HELO = "HELO ";
                String MAIL_FROM = "MAIL FROM: " + mailFrom;
                String RCPT_TO = "RCPT TO: user@emailadress.com ";
                String SUBJECT = "SUBJECT: Java is cool!";
                String DATA = name;    // ������ ���������

                // �������: "\r\n.\r\n" ��������� �� ����� ���������
                String BODY = message + "\r\n.\r\n";

                Socket smtp = null;     // ����� SMTP

                try {    // �������: 25 - ��� ����������� ����� ����� SMTP
                    smtp = new Socket("mail.smtp.host", 25);
                    OutputStream os = smtp.getOutputStream();
                    ps = new PrintStream(os);
                    InputStream is = smtp.getInputStream();
                    dis = new DataInputStream(is);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {  // ������ SMTP helo
                    String loc = InetAddress.getLocalHost().getHostName();
                    send(HELO + loc);
                    receive();          // ��������� ������ SMTP
                    send(MAIL_FROM);    // ������� �� SMTP
                    receive();          // ��������� ������ SMTP
                    send(RCPT_TO);      // ������� �������� SMTP
                    receive();          // ��������� ������ SMTP
                    send(DATA);         // ���������� ������� �� SMTP
                    receive();          // ��������� ������ SMTP
                    send(SUBJECT);      // ������� ���� �� SMTP
                    receive();          // ��������� ������ SMTP
                    send(BODY);         // ������� ���� ���������
                    receive();          // ��������� ������ SMTP
                    smtp.close();       //
                } catch (IOException w) {
                    System.out.println("Error sending: " + w);
                }

                System.out.println("Mail sent!");

            }
        }).start();


    }

    public static void send(String str) throws IOException {
        ps.println(str);      // ������� ������ �� SMTP
        ps.flush();           // ������� ������
        System.out.println("Java sent: " + str);
    }

    public static void receive() throws IOException {
        String readstr = dis.readLine();  // ��������� ������ �� SMTP
        System.out.println("SMTP respons: " + readstr);
    }
}