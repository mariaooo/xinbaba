package com.hsbc.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ZhanShen on 2018/1/18.
 */
@Controller
public class Test {
    @RequestMapping(value = "/test/index.shtml")
    public String index() {
        System.out.println("Hello enan");
        return "/index.jsp";
    }
}
