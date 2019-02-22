package com.quest.test.json.tools;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.sun.java.browser.net.ProxyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.alibaba.fastjson.JSON.parseObject;

/**
 * Created by Quest on 2018/8/21.
 */
public class JsonConvertUtil {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(ProxyService.class);

    public static <T> T resultSet(Class[] clz,String res) throws Exception {
        try {
            ResponseBean<T> result;
            if (clz.length > 1) {
                List<Class> clzList = new ArrayList<>(Arrays.asList(clz));
                clzList.remove(0);
                Class[] sub = clzList.toArray(new Class[clzList.size()]);

                JavaType javaType = mapper.getTypeFactory().constructParametrizedType(clz[0], clz[0], sub);
                result = mapper.readValue(res, mapper.getTypeFactory().constructParametrizedType(ResponseBean.class, ResponseBean.class, javaType));

            } else {
                result = mapper.readValue(res, mapper.getTypeFactory().constructParametrizedType(ResponseBean.class, ResponseBean.class, clz[0]));
            }
            if (result.getCode() == 200) {
                return result.getBody();
            } else {
                throw new Exception(result.getMsg());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

    }

    public static <T> T resultSet2(Class[] clz,String res) throws Exception {
        return  (T)JSON.parseObject(res,clz[0]);
    }

    static {
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);//允许特殊符号出现
//        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }
}
