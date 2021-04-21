package com.sc.study.upload;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-11-03 20:53
 * @desc
 */
public class ImageUpload {

    public static void main(String[] args) {
        ImageUpload imageUpload = new ImageUpload();
        String baseUrl = "/Users/zdwh/Desktop/";
        String[] folders = new String[]{"搜索图片"};
        List<String> foldersList = Arrays.asList(folders);
        CountDownLatch countDownLatch = new CountDownLatch(foldersList.size());
        foldersList.forEach(item -> new Thread(
                () -> {
                    imageUpload.imageUploadWithFolder(baseUrl + item, item);
                    countDownLatch.countDown();
                }
        ).start());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("上传任务全部完成。。。。。。。。。");
    }


    /**
     * 文件夹形式上传
     */
    private void imageUploadWithFolder(String path, String fileName) {
        File file = new File(path);
        File[] array = file.listFiles();
        if (null == array) {
            System.out.println("文件夹是空的哦");
            return;
        }

        for (File file1 : array) {
            if (file1.isFile()) {
                uploadImage(file1, fileName+"/"+"图片路径");

            } else if (file1.isDirectory()) {
                imageUploadWithFolder(file1.getPath(), fileName + "/" + file1.getName());

            }
        }

    }

    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    private String uploadImage(File file, String fileName) {
        if (null == file || !file.exists()) {
            System.out.println("文件不存在");

            return null;

        }
        String url = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://static.wanwudezhi.com/api/uploader/uploadImage?retainName=false&skipCompress=false&disableCache=false");

        FileBody bin = new FileBody(file, ContentType.create("image/png", Consts.UTF_8));
        //创建图片提交主体信息
        HttpEntity entity = MultipartEntityBuilder
                .create()
                .setCharset(Charset.forName("utf-8"))
                .addPart("file", bin)
                //添加到请求
                .build();
        httpPost.setEntity(entity);
        //发送Post,并返回一个HttpResponse对象
        HttpResponse response;
        try {
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                //如果状态码为200,就是正常返回
                String result = EntityUtils.toString(response.getEntity());
                JSONObject jsonObject = JSON.parseObject(result);
                if (null != jsonObject) {
                    Object urlObj = jsonObject.get("result");
                    if (null != urlObj) {
                        System.out.println("URL:" + urlObj);
                        url = urlObj.toString();
                        appendFileWithBufferedWriter(fileName, url);
                    }


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }

    /**
     * 写入
     *
     * @throws IOException
     */
    private void appendFileWithBufferedWriter(String fileName, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/zdwh/Desktop/" + fileName, true));
        writer.write(content);
        writer.newLine();
        writer.flush();
        writer.close();
    }

}
