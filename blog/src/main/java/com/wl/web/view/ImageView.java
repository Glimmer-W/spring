package com.wl.web.view;

import org.springframework.web.servlet.View;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.Map;

/**
 * 自定义图片视图，分离控制器与图片下载代码的职责
 */
public class ImageView implements View {

    private  String fileUploadPath;

    private String imageName;

    public ImageView(String fileUploadPath, String imageName) {
        this.imageName = imageName;
        this.fileUploadPath = fileUploadPath;
    }

    @Override
    public String getContentType() {
        return "image/jpeg/jpg/png/gif/bmp";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        File image;
        FileImageInputStream in = null;
        OutputStream out = null;
        try {
            image = new File(fileUploadPath + File.separator + imageName);
            if (!image.exists()) {
                throw new FileNotFoundException("没有找到此文件：" + imageName);
            }
            in = new FileImageInputStream(image);
            out = httpServletResponse.getOutputStream();
            byte[] bytes = new byte[1024];
            while (in.read(bytes) != -1) {
                out.write(bytes);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }


}
