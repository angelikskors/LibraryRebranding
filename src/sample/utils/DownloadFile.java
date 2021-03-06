package sample.utils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


public class DownloadFile {


    public DownloadFile(String url, String toFile) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                File newFile = new File(toFile);
                if (!newFile.exists()) {
                    try {
                        newFile.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Started");

                URL link = null; //The file that you want to download
                try {
                    link = new URL(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                //Code to download
                InputStream in = null;
                try {
                    in = new BufferedInputStream(link.openStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int n = 0;
                try {
                    while (-1 != (n = in.read(buf))) {
                        out.write(buf, 0, n);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte[] response = out.toByteArray();

                try (FileOutputStream fos = new FileOutputStream(toFile)) {
                    fos.write(response);
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //End download code

                System.out.println("Finished");
            }
        }).start();

    }
}
