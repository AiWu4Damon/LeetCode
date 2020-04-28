package com.damon.worm.utils;

import okhttp3.*;
import org.springframework.http.MediaType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: //TODO(对象型指标操作表)
 * @Author: fjy
 * @Date: 2020/4/6 0006 21:56
 * @Version: V1.0
 */
public class OkHttpUtils {


    public static void run(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .header("User-Agent", "PostmanRuntime")
                .addHeader("Accept", "*/*")
                .build();
        //同步
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            int len;
            byte[] buf = new byte[2048];
            File file = new File("d:/test.html");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            InputStream inputStream = response.body().byteStream();
            while ((len = inputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, len);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            inputStream.close();
        } else {
            throw new IOException("Unexpected code " + response);
        }
        //异步
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//            }
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if (response.isSuccessful()) {
//                    int len;
//                    byte[] buf = new byte[2048];
//                    File file = new File("d:/test.html");
//                    FileOutputStream fileOutputStream = new FileOutputStream(file);
//                    InputStream inputStream = response.body().byteStream();
//                    while ((len = inputStream.read(buf)) != -1) {
//                        fileOutputStream.write(buf, 0, len);
//                    }
//                    fileOutputStream.flush();
//                    fileOutputStream.close();
//                    inputStream.close();
//                } else {
//                    throw new IOException("Unexpected code " + response);
//                }
//            }
//        });
        System.out.println("end+++++");
    }

    public static void main(String[] args) throws IOException {
        String url = "https://www.mm820.com/chapter/115591";
        run(url);
    }
}
