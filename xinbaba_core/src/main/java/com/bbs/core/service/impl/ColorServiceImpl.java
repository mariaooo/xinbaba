package com.bbs.core.service.impl;

import com.bbs.core.bean.product.Color;
import com.bbs.core.bean.product.ColorQuery;
import com.bbs.core.dao.product.ColorDao;
import com.bbs.core.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhanShen on 2018/3/11.
 */
@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorDao colorDao;

    @Override
    public List<Color> selectColorByColorQuery(ColorQuery colorQuery) {
        return colorDao.selectByExample(colorQuery) ;
    }

    @Override
    public Color selectColorById(Long id) {
        return colorDao.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateColor(Color color) {
        return colorDao.updateByPrimaryKeySelective(color) ;
    }
}
