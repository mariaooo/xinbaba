package com.bbs.core.bean;

import java.util.ResourceBundle;

/**
 * Created by ZhanShen on 2018/2/13.
 */
public class Constants {
    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("url");
        IMG_URL = resourceBundle.getString("IMG_URL");
    }
    public static final String IMG_URL ;
}
