package com.bbs.core.service;

import com.bbs.core.bean.product.Color;
import com.bbs.core.bean.product.ColorQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZhanShen on 2018/3/11.
 */
@Transactional
public interface ColorService {
    List<Color> selectColorByColorQuery(ColorQuery colorQuery);
    Color selectColorById(Long id);
    Integer updateColor(Color color);
}
