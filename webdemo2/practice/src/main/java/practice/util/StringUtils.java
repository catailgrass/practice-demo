package practice.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {
    public static boolean isEmpty(String str){
        boolean result = false;
        if (null == str || "".equals(str))
            result = true;
        return result;
    }
    public static void asList() {
        List list = Arrays.asList(1, 23, 4, 4);
        list.add("df");
        List sfd = new ArrayList<Integer>(){{
            add(1);
            add(23);
            add(4);
            add(4);
        }};
        System.out.println(list.toString()+sfd.toString());
    }

    public static void main(String[] args) {
        asList();
    }
}
