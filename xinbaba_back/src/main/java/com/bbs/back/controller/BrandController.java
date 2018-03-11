package com.bbs.back.controller;

import com.bbs.core.bean.brand.Brand;
import com.bbs.core.bean.brand.BrandQuery;
import com.bbs.core.bean.Constants;
import com.bbs.core.bean.Page;
import com.bbs.core.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        model.addAttribute("url", Constants.IMG_URL);
        return "brand/list";
    }

    @RequestMapping(value = "/insertBrand")
    public String insertBrand(Brand brand) {
        System.out.println(brand.toString());
        brandService.insertBrand(brand);
        return "redirect:/brand/list.do";
    }

    @RequestMapping(value = "/delete.do", method = {RequestMethod.POST, RequestMethod.GET})
    public String deleteBrand(Long[] ids, Integer pageNo, String name, Byte isDisplay) {
        brandService.deleteBrand(ids);
        return "forward:/brand/list.do";
    }

    @RequestMapping(value="/update.do")
    public String updateBrand(Brand brand) {
        brandService.updateBrand(brand);
        return "redirect:/brand/list.do";
    }

    @RequestMapping(value="/select.do")
    public String selectBrand(Model model, Long id) {
        Brand brand = brandService.selectBrandById(id);
        model.addAttribute("brand",brand);
        model.addAttribute("url", Constants.IMG_URL);
        return "brand/edit";
    }

}
