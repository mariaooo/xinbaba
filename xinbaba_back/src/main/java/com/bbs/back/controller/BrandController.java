package com.bbs.back.controller;

import com.bbs.core.bean.Brand;
import com.bbs.core.bean.BrandQuery;
import com.bbs.core.bean.Page;
import com.bbs.core.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ZhanShen on 2018/2/1.
 */
@Controller
@RequestMapping(value = "/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/list.do")
    public String brandList(Model model, String name, Byte isDisplay, Integer pageNo) {
        BrandQuery brandQuery = new BrandQuery();
        brandQuery.setName(name);
        if (pageNo == null) {
            pageNo = 1;
        }
        brandQuery.setPageNo(pageNo);
        if (isDisplay == null) {
            isDisplay = 1;
        }
        brandQuery.setIsDisplay(isDisplay);
        Page<Brand> page = brandService.selectBrandPageByQuery(brandQuery);
        model.addAttribute("page", page);
        model.addAttribute("name", name);
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("isDisplay", isDisplay);
        return "brand/list";
    }

    @RequestMapping(value = "/insertBrand")
    public String insertBrand(Brand brand) {
        System.out.println(brand.toString());
        brandService.insertBrand(brand);
        return "redirect:/brand/list.do";
    }

}
