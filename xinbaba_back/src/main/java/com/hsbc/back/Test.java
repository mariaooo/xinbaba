package com.hsbc.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ZhanShen on 2018/1/18.
 */
@Controller
public class Test {

    @RequestMapping(value = "/test/index.do")
    public String index() {
        return "/index.jsp";
    }
}
