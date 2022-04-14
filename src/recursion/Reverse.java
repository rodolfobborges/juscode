package recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Reverse {

    static String reverseThe(String s) {
        return s.length() == 0 ? s : s.substring(s.length()-1).concat(reverseThe(s.substring(0, s.length()-1)));
    }

    static String reverseThe(String[] aos) {

        List<String> list = Arrays.asList(aos);
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder(list.size());
        for (String s : list) {
            sb.append(s).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseThe("bento"));
        String[] aos = {"bento", "marcos", "cacau"};
        System.out.println(reverseThe(aos));
    }
}
