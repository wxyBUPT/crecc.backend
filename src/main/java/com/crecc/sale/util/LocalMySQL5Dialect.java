package com.crecc.sale.util;

import org.hibernate.dialect.MySQL5Dialect;

/**
 * Created by xiyuanbupt on 2018/11/23.
 */
public class LocalMySQL5Dialect extends MySQL5Dialect{
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
