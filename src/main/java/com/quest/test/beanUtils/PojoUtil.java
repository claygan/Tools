package com.quest.test.beanUtils;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Quest on 2018/8/17.
 */
public class PojoUtil {
    public PojoUtil() {
    }

    public static <T> T convert(Object object, Class<T> clazz) {
        return convert(object, clazz, (Mapper)null);
    }

    public static <T> T convert(Object object, Class<T> clazz, String... mappers) {
        return convert(object, clazz, new Mapper(mappers));
    }

    public static <T> T convert(Object object, Class<T> clazz, Mapper mapper) {
        if (object == null) {
            return null;
        } else {
            T t = JSON.toJavaObject(JSON.parseObject(JSON.toJSONString(object)), clazz);
            if (mapper != null) {
                Map<String, String> map = mapper.getAll();
                if (map != null && map.size() > 0) {
                    Class<?> origclz = object.getClass();
                    Iterator i$ = map.entrySet().iterator();

                    while(i$.hasNext()) {
                        Map.Entry entry = (Map.Entry)i$.next();

                        try {
                            Field origField = origclz.getDeclaredField((String)entry.getKey());
                            origField.setAccessible(true);
                            Object value = origField.get(object);
                            if (value != null) {
                                Field destField = clazz.getDeclaredField((String)entry.getValue());
                                destField.setAccessible(true);
                                destField.set(t, value);
                            }
                        } catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchFieldException var11) {
                            ;
                        }
                    }
                }
            }

            return t;
        }
    }

    public static <T> List<T> convert(List<?> list, Class<T> clazz) {
        return convert(list, clazz, (Mapper)null);
    }

    public static <T> List<T> convert(List<?> list, Class<T> clazz, String... mappers) {
        return convert(list, clazz, new Mapper(mappers));
    }

    public static <T> List<T> convert(List<?> list, Class<T> clazz, Mapper mapper) {
        if (list == null) {
            return null;
        } else {
            List<T> result = new ArrayList();
            Iterator i$ = list.iterator();

            while(i$.hasNext()) {
                Object object = i$.next();
                result.add(convert(object, clazz, mapper));
            }

            return result;
        }
    }
}
