package com.quest.test.beanUtils;

import java.util.HashMap;
import java.util.Map;

public class Mapper {
    private Map<String, String> mapper = new HashMap();

    public Mapper() {
    }

    public Mapper(String... mappers) {
        this.addAny(mappers);
    }

    public Mapper addAny(String... mappers) {
        for(int i = 0; mappers != null && i < mappers.length; ++i) {
            if (isNotBlank(new String[]{mappers[i]})) {
                mappers[i] = mappers[i].replaceAll("\\s+", "");
                String[] keyvals = mappers[i].split(",");

                for(int j = 0; keyvals != null && j < keyvals.length; ++j) {
                    if (keyvals[j].matches("^\\w+\\-\\>\\w+$")) {
                        this.addOne(keyvals[j].split("->")[0], keyvals[j].split("->")[1]);
                    }
                }
            }
        }

        return this;
    }

    public Mapper addOne(String orig, String dest) {
        this.mapper.put(orig, dest);
        return this;
    }

    public String mapper(String orig) {
        return (String)this.mapper.get(orig);
    }

    public String remove(String orig) {
        return (String)this.mapper.remove(orig);
    }

    public Map<String, String> getAll() {
        return this.mapper;
    }

    public Mapper clear() {
        this.mapper.clear();
        return this;
    }

    public static boolean isNotBlank(String... strs) {
        String[] arr$ = strs;
        int len$ = strs.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String str = arr$[i$];
            if (isEmpty(str)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}
