package com.bbs.back.controller;

import com.bbs.core.bean.Page;
import com.bbs.core.bean.brand.Brand;
import com.bbs.core.bean.brand.BrandQuery;
import com.bbs.core.bean.product.*;
import com.bbs.core.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by ZhanShen on 2018/3/7.
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private BrandService brandServer;

    @Autowired
    private ProductServer productServer;

    @Autowired
    private FeatureService featureService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private ColorService colorService;

    @RequestMapping("/list.do")
    public String list(Integer pageNo, String name, Boolean isShow, Long brandId, Model model) {
        ProductQuery productQuery = new ProductQuery();
        ProductQuery.Criteria criteria = productQuery.createCriteria();
        // not del
        criteria.andIsDelEqualTo(true);
        //set pageno
        if (pageNo != null) {
            productQuery.setPageNo(pageNo);
        } else {
            productQuery.setPageNo(1);
        }

        //set name
        if (name != null) {
            criteria.andNameLike("%" + name + "%");
            model.addAttribute("name", name);
        }

        //set isshow
        if (isShow != null) {
            criteria.andIsShowEqualTo(isShow);
            model.addAttribute("isShow", isShow);
        } else {
            criteria.andIsShowEqualTo(false);
            model.addAttribute("isShow", false);
        }

        //set brand id
        if (brandId != null) {
            criteria.andBrandIdEqualTo(brandId);
            model.addAttribute("brandId", brandId);
        }

        //set brand list
        BrandQuery brandQuery = new BrandQuery();
        brandQuery.setIsDisplay((byte) 1);
        List<Brand> brands = brandServer.selectBrandListByQuery(brandQuery);
        model.addAttribute("brands", brands);

        //set product page info
        Page<Product> products = productServer.selectProductByPage(productQuery);
        model.addAttribute("products", products);
        model.addAttribute("pageNo", products.getPageNo());

        return "product/list";
    }

    @RequestMapping(value="/toAdd.do")
    public String toAddProduct(Model model) {
        // select all features
        FeatureQuery featureQuery = new FeatureQuery();
        FeatureQuery.Criteria criteria = featureQuery.createCriteria().andIsDelEqualTo(true).andIsDelEqualTo(true);
        List<Feature> features = featureService.selectFeaturebyFeatureQuery(featureQuery);
        model.addAttribute("features", features);
        // select colors
        ColorQuery colorQuery = new ColorQuery();
        ColorQuery.Criteria criteria1 = colorQuery.createCriteria().andParentIdNotEqualTo(0L);
        List<Color> colors = colorService.selectColorByColorQuery(colorQuery);
        model.addAttribute("colors",colors);
        // select Type
        TypeQuery typeQuery = new TypeQuery();
        TypeQuery.Criteria criteria2 = typeQuery.createCriteria().andParentIdEqualTo(1L).andIsDisplayEqualTo(true);
        List<Type> types = typeService.selectTypeByTypeQuery(typeQuery);
        model.addAttribute("types",types);
        //select brands
        BrandQuery brandQuery = new BrandQuery();
        brandQuery.setIsDisplay((byte) 1);
        List<Brand> brands = brandServer.selectBrandListByQuery(brandQuery);
        model.addAttribute("brands", brands);
        return "product/add";
    }

    @RequestMapping(value="/product/add.do")
    public String addProduct(Product product) {
        product.setIsShow(false);
        productServer.insertProduct(product);
        return "redirect:/product/list.do";
    }

}
