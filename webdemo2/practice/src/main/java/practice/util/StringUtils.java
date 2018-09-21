package practice.util;

public class StringUtils {
    public static boolean isEmpty(String str){
        boolean result = false;
        if (null == str || "".equals(str))
            result = true;
        return result;
    }
}
