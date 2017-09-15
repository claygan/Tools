package com.quest.commons.utils;

import org.apache.commons.lang3.StringUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Quest on 2017/9/15.
 */
public final class BeanUtil {

    private BeanUtil() {
    }

    /**
     *@Description: bean转Map
     */
    public static HashMap<String,Object> beanToMap(Object bean){
        HashMap<String,Object> map = new HashMap<String,Object>();
        if(null == bean){
            return map;
        }
        Class<?> clazz = bean.getClass();
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(clazz);
        } catch (IntrospectionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
        for(PropertyDescriptor descriptor : descriptors){
            String propertyName = descriptor.getName();
            if(!"class".equals(propertyName)){
                Method method = descriptor.getReadMethod();
                Object result;
                try {
                    result = method.invoke(bean);
                    if(null != result){
                        map.put(propertyName, result);
                    }else{
                        map.put(propertyName, "");
                    }
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return map;
    }

    /**
     * 将Bean中的属性反射到Map中
     *
     * @param bean   要反射的Bean
     * @param ignore 忽略null和''
     * @return 保存字段值的集合
     */
    public static Map<String, Object> bean2map(
            Object bean, boolean ignore) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (bean != null) {
            Class<?> clazz = bean.getClass();
            while (clazz != null && clazz != Object.class) {
                fields2map(bean, clazz.getDeclaredFields(), map, ignore);
                clazz = clazz.getSuperclass();
            }
        }
        return map;
    }

    /**
     * 遍历Map并将其反射到Bean中
     *
     * @param map   要反射的map
     * @param clazz 返回对象类型
     * @return 保存字段值的集合
     */
    public static <T> T map2bean(
            Map<String, Object> map, Class<T> clazz) {
        if (map == null) {
            return null;
        }
        try {
            T bean = clazz.newInstance();
            Class<?> _clazz = bean.getClass();
            while (_clazz != null && _clazz != Object.class) {
                map2fields(bean, _clazz.getDeclaredFields(), map);
                _clazz = _clazz.getSuperclass();
            }
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void fields2map(Object bean, Field[] fields,
                                   Map<String, Object> map, boolean ignore) {
        try {
            for (int i = 0; fields != null && i < fields.length; i++) {
                fields[i].setAccessible(true);
                Object value = fields[i].get(bean);
                if (isNotNull(value) || (!ignore)) {
                    map.put(fields[i].getName(), value);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void map2fields(Object bean, Field[] fields,
                                   Map<String, Object> map) {
        try {
            for (int i = 0; fields != null && i < fields.length; i++) {
                fields[i].setAccessible(true);
                Object value = map.get(fields[i].getName());
                if (value != null) {
                    fields[i].set(bean, value);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isNotNull(Object value) {
        if (value == null) {
            return false;
        } else {
            if (value instanceof String) {
                return StringUtils.isNotBlank((String) value);
            } else {
                return true;
            }
        }
    }
}
