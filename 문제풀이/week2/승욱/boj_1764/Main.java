package 문제풀이.week2.승욱.boj_1764;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N + M; i++) {
            String s = sc.next();
            if (map.containsKey(s)) {
                map.put(s, 2);
            } else {
                map.put(s, 1);
            }
        }
        int count = 0;
        List<String> result = new ArrayList<>();

        for (String s : map.keySet()) {
            if (map.get(s) == 2) {
                count++;
                result.add(s);
            }
        }
        System.out.println(count);
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
