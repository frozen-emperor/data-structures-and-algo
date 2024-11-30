package map;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg","add"));
        System.out.println(isIsomorphic("foo","bar"));
    }

    public static boolean isIsomorphic(String s, String t) {
        return s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).size()
                == t.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).size();
    }
}
