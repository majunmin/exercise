package com.mjm.io;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * -Xmx20M -Xms20M -Xmn5M
 *
 * @author majunmin
 * @description
 * @datetime 2020/3/6 7:45 下午
 * @since
 */
public class FileInputStreamTest {

    public static void main(String[] args) {

        String downLoadUrl = "https://drive.google.com/uc?export=download&id=1efAGZtukqwqCBTdCmTUq5_Rxlc1xIJEm";
        String dstFilePath = "./down1.apk";
        downLoadFile(downLoadUrl, dstFilePath);
    }

    private static void downLoadFile(String downLoadUrl, String dstFilePath) {
        try (InputStream inputStream = new URL(downLoadUrl).openStream();
             ByteArrayOutputStream fileOutputStream = new ByteArrayOutputStream()){

            byte[] buf = new byte[1024];
            int len = -1;
            while((len = inputStream.read(buf)) != -1){
                fileOutputStream.write(buf, 0, len);
            }
//            new FileOutputStream(dstFilePath).write(fileOutputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
