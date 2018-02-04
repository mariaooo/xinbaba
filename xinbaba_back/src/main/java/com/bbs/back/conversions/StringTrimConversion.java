package com.bbs.back.conversions;

import org.springframework.core.convert.converter.Converter;

/**
 * Created by ZhanShen on 2018/2/2.
 */
public class StringTrimConversion implements Converter<String,String> {

    @Override
    public String convert(String source) {
        if (source != null && !"".equals(source)){
            return source;
        }
        return null;
    }
}
