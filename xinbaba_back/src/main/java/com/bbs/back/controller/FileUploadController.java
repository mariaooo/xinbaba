package com.bbs.back.controller;

import com.bbs.core.bean.Constants;
import com.bbs.core.utils.FastDFSUtils;
import net.fckeditor.response.UploadResponse;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Set;

/**
 * Created by ZhanShen on 2018/2/4.
 */
@Controller
@RequestMapping(value = "/upload")
public class FileUploadController {

//    @RequestMapping(value = "/brand/addImg.do")
//    public void brandImgUpload(@RequestParam MultipartFile pic, HttpServletResponse res, String imgUrl) throws IOException {
//         ResourceBundle url = ResourceBundle.getBundle("url");
//         String path = url.getString("brand.img.upload.url");
//        if (!(imgUrl == null || "".equals(imgUrl))) {
//            File oldFile = new File(path + "/" + imgUrl);
//            oldFile.delete();
//        }
//        //create name of pic
//        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//        String name = df.format(new Date());
//        Random random = new Random();
//        for (int i = 0; i < 3; i++) {
//            name += random.nextInt(10);
//        }
//        String fileName = name + "." + FilenameUtils.getExtension(pic.getOriginalFilename());
//        String realPath = path + "/" + fileName;
//        pic.transferTo(new File(realPath));
//        JSONObject jsonObject = new JSONObject();
//        String visualPath = url.getString("brand.img.visual.url");
//        jsonObject.put("path", visualPath + "/" + fileName);
//        jsonObject.put("filename", fileName);
//        res.setContentType("application/json;chartset=UTF-8");
//        res.getWriter().write(jsonObject.toString());
//    }

    @RequestMapping(value = "/brand/addImg.do")
    public void brandImgUpload(@RequestParam MultipartFile pic, HttpServletResponse res, String imgUrl) throws IOException {
        if (!(imgUrl == null || "".equals(imgUrl))) {
            Integer i = FastDFSUtils.deletePic(imgUrl);
            System.out.println(i);
        }
        String path = FastDFSUtils.uploadPic(pic);
        String url = Constants.IMG_URL + "/" + path;
        JSONObject json = new JSONObject();
        json.put("path", path);
        json.put("url",url);
        res.setContentType("application/json;charSet=UTF-8;");
        res.getWriter().write(json.toString());
    }

    @RequestMapping(value = "/brand/delImg.do", method = RequestMethod.POST)
    public String delImg(String path) throws URISyntaxException {
        if (!(path == null || path == "")) {
            Integer i = FastDFSUtils.deletePic(path);
            System.out.println(i);
        }
        return "forward:/brand/list.do";
    }
    
    @RequestMapping(value="/uploadFck.do")
    public void fckImgUpload(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // hand convert to multi
        MultipartRequest mr = (MultipartRequest) req;
        Map<String, MultipartFile> fileMap = mr.getFileMap();
        Set<Map.Entry<String, MultipartFile>> entries = fileMap.entrySet();
        for (Map.Entry<String,MultipartFile> entry :entries) {
            String url = Constants.IMG_URL + "/" + FastDFSUtils.uploadPic(entry.getValue());
            UploadResponse ok = UploadResponse.getOK(url);
            res.getWriter().print(ok);
        }
    } 

}
