package 문제풀이.week5.승욱.boj_1181;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<String> s = new LinkedHashSet<>();
        for (int i = 0; i < N; i++) {
            s.add(sc.next());
        }

        List<String> list = new ArrayList<>(s);
        Collections.sort(list, Comparator.comparing(String::length)
                .thenComparing(o -> o));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
