package com.yunsheng.yunsheng_springboot_back.generator.Common;

public class ThreadUtil {
    private static ThreadLocal list = new ThreadLocal();

    public static void set(Object value) {
        list.set(value);
    }

    public static <T> T get() {
        return (T) list.get();
    }

    public static void remove() {
        list.remove();
    }

}
