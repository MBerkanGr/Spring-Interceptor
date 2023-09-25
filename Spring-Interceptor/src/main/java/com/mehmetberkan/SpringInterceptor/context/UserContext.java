package com.mehmetberkan.SpringInterceptor.context;

import java.util.HashMap;
import java.util.Map;

public class UserContext {

    private static final ThreadLocal<Map<String,String>> mapThreadLocal = ThreadLocal.withInitial(HashMap::new);
    
    public static Map<String,String> getValue() {
        return mapThreadLocal.get();
    }

    public static void setValue(Map<String,String> stringMap) {
        mapThreadLocal.set(stringMap);
    }
}
