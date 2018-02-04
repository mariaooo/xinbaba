package com.bbs.back.controller;

import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * Created by ZhanShen on 2018/2/4.
 */
@Controller
@RequestMapping(value = "/upload")
public class FileUploadController {

    @RequestMapping(value = "/brand/addImg.do")
    public void brandImgUpload(@RequestParam MultipartFile pic, HttpServletResponse res) throws IOException {
        ResourceBundle url = ResourceBundle.getBundle("url");
        String path = url.getString("brand.img.upload.url");
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String name = df.format(new Date());
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            name += random.nextInt(10);
        }
        String fileName = name + "." + FilenameUtils.getExtension(pic.getOriginalFilename());
        String realPath = path + "/" + fileName;
        pic.transferTo(new File(realPath));
        JSONObject jsonObject = new JSONObject();
        String visualPath = url.getString("brand.img.visual.url");
        jsonObject.put("path", visualPath + "/" + fileName);
        jsonObject.put("filename", fileName);
        res.setContentType("application/json;chartset=UTF-8");
        res.getWriter().write(jsonObject.toString());
    }

    @RequestMapping(value = "/brand/delImg.do", method = RequestMethod.POST)
    public String delImg(String filename) throws URISyntaxException {
        if (filename != null) {
            ResourceBundle url = ResourceBundle.getBundle("url");
            File file = new File(url.getString("brand.img.upload.url") + "/" + filename);
            file.delete();
        }
        return "forward:/brand/list.do";
    }

}
