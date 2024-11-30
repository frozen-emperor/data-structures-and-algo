package map;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        Map<Integer, Integer> map = Map.of(
                0, 0,
                1, 1,
                2, 4,
                3, 9,
                4, 16,
                5, 25,
                6, 36,
                7, 49,
                8, 64,
                9, 81
        );

        Set<Integer> visited =  new HashSet<>();

        while(n > 9){
            int sum = 0;

            if(visited.contains(n))
                return false;

            visited.add(n);
            while(n > 0) {
                int r = n % 10;
                sum += map.get(r);

                n /=10;
            }


            n = sum;
        }

        return n == 1;
    }
}
