package com.quest.test;

/**
 * 产品编码处理工具类
 */
public class ProductUtil {

    public static String getParentProductCode(String productCode){
        return productCode.substring(0,productCode.lastIndexOf("_"));
    }
    public static String getTenantId(String productCode){
        return productCode.substring(0,productCode.lastIndexOf("."));
    }

}
