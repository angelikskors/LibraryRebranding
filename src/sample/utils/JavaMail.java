package sample.utils;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class JavaMail {

    static PrintStream ps = null;          // посылка сообщений
    static DataInputStream dis = null;     // получение сообщений

    public JavaMail(String name, String mailFrom, String message) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                String HELO = "HELO ";
                String MAIL_FROM = "MAIL FROM: " + mailFrom;
                String RCPT_TO = "RCPT TO: user@emailadress.com ";
                String SUBJECT = "SUBJECT: Java is cool!";
                String DATA = name;    // начало сообщения

                // заметка: "\r\n.\r\n" указывает на конец сообщения
                String BODY = message + "\r\n.\r\n";

                Socket smtp = null;     // сокет SMTP

                try {    // заметка: 25 - это стандартный номер порта SMTP
                    smtp = new Socket("mail.smtp.host", 25);
                    OutputStream os = smtp.getOutputStream();
                    ps = new PrintStream(os);
                    InputStream is = smtp.getInputStream();
                    dis = new DataInputStream(is);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {  // скажем SMTP helo
                    String loc = InetAddress.getLocalHost().getHostName();
                    send(HELO + loc);
                    receive();          // получение ответа SMTP
                    send(MAIL_FROM);    // посылка на SMTP
                    receive();          // получение ответа SMTP
                    send(RCPT_TO);      // посылка адресату SMTP
                    receive();          // получение ответа SMTP
                    send(DATA);         // начинается посылка на SMTP
                    receive();          // получение ответа SMTP
                    send(SUBJECT);      // посылка темы на SMTP
                    receive();          // получение ответа SMTP
                    send(BODY);         // посылка тела сообщения
                    receive();          // получение ответа SMTP
                    smtp.close();       //
                } catch (IOException w) {
                    System.out.println("Error sending: " + w);
                }

                System.out.println("Mail sent!");

            }
        }).start();


    }

    public static void send(String str) throws IOException {
        ps.println(str);      // посылка строки на SMTP
        ps.flush();           // очистка буфера
        System.out.println("Java sent: " + str);
    }

    public static void receive() throws IOException {
        String readstr = dis.readLine();  // получение ответа от SMTP
        System.out.println("SMTP respons: " + readstr);
    }
}