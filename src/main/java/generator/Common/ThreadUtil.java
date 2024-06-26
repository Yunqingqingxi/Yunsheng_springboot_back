package generator.Common;

/**
 * 线程检查
 */
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
