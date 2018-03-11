package com.bbs.core.service.impl;

import com.bbs.core.bean.product.Type;
import com.bbs.core.bean.product.TypeQuery;
import com.bbs.core.dao.product.TypeDao;
import com.bbs.core.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhanShen on 2018/3/11.
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public List<Type> selectTypeByTypeQuery(TypeQuery typeQuery) {
        return typeDao.selectByExample(typeQuery);
    }

    @Override
    public Type selectTypeById(Long id) {
        return typeDao.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateType(Type type) {
        return typeDao.updateByPrimaryKeySelective(type);
    }
}
