package com.bbs.core.service;

import com.bbs.core.bean.product.Type;
import com.bbs.core.bean.product.TypeQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ZhanShen on 2018/3/11.
 */
@Transactional
public interface TypeService {
    List<Type> selectTypeByTypeQuery(TypeQuery typeQuery);
    Type selectTypeById(Long id);
    Integer updateType(Type type);
}
