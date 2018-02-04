package com.bbs.back.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ZhanShen on 2018/1/24.
 */
@Controller
@RequestMapping(value = "/view", method={RequestMethod.GET})
public class ViewController {
    @RequestMapping(value="/{name}.do")
    public String toView(@PathVariable("name") String name) {
        return name;
    }

    @RequestMapping(value="/{path}/{name}.do")
    public String toSecondView(@PathVariable("name") String name, @PathVariable("path") String path) {
        return path+"/"+name;
    }
}
