package 문제풀이.week5.승욱.boj_4673;

public class Main {
    public static void main(String[] args) {
        boolean[] check = new boolean[10001];
        for (int i = 1; i <= 10000; i++) {
            int temp = i;
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                temp += (s.charAt(j) - '0');
            }
            if (temp < 10001)
                check[temp] = true;
        }
        for (int i = 1; i <= 10000; i++) {
            if (!check[i]) {
                System.out.println(i);
            }
        }
    }
}
