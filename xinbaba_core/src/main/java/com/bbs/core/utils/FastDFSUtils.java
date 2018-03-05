package com.bbs.core.utils;

import org.apache.commons.io.FilenameUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ZhanShen on 2018/2/13.
 */
public class FastDFSUtils {

    private static StorageClient1 storageClient1;

    static {
        try {
            ClassPathResource resource = new ClassPathResource("fdfs_client.conf");
            ClientGlobal.init(resource.getClassLoader().getResource("fdfs_client.conf").getPath());
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageServer storageServer = null;
            storageClient1 = new StorageClient1(trackerServer, storageServer);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public static String uploadPic(MultipartFile pic) {
        NameValuePair[] meta_list = new NameValuePair[3];
        // extension
        String ext = FilenameUtils.getExtension(pic.getOriginalFilename());
        System.out.println(pic.getName());
        System.out.println(pic.getOriginalFilename());
        meta_list[0] = new NameValuePair("filename", pic.getOriginalFilename());
        meta_list[1] = new NameValuePair("filelength", String.valueOf(pic.getSize()));
        meta_list[2] = new NameValuePair("ext", ext);
        //http://192.168.200.128/group1/M00/00/01/wKjIgFWOYc6APpjAAAD-qk29i78248.jpg
        String path = null;
        try {
            path = storageClient1.upload_file1(pic.getBytes(), ext, meta_list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    public static Integer deletePic(String path) {
        Integer i = null;
        try {
            i = storageClient1.delete_file1(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
