package com.yunsheng.yunsheng_springboot_back.generator.Common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R<T> {
    private int code;
    private String msg;
    private T data;
    private Map map = new HashMap();

    public static <T> R<T> success(T object) {
        R<T> r = new R<>();
        r.setCode(0);
        r.setData(object);
        return r;
    }

    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 1;
        return r;
    }


}





