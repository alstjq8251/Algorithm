package 문제풀이.week3.승욱.boj_3085;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static String[][] arr;
    static int[] dx = {1,0}; // 아래, 오른쪽
    static int[] dy = {0,1};
    static int answer;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new String[N][N];
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            String[] str = s.split("");
            for (int j = 0; j < str.length; j++) {
                arr[i][j] = str[j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bfs(i, j);
            }
        }
        System.out.println(answer);

    }
    public static void bfs(int a, int b) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, b));
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int x = node.x;
            int y = node.y;
            for (int i = 0; i < 2; i++) {
                String[][] copy = copy();
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    String temp = copy[x][y];
                    copy[x][y] = copy[nx][ny];
                    copy[nx][ny] = temp;
                    int result = check(copy);
                    if (answer < result) {
                        answer = result;
                    }
                }
            }
        }
    }

    public static int check(String[][] copy) {
        int temp = 1;
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (copy[i][j].equals(copy[i][j-1])) {
                    count++;
                } else {
                    count = 1;
                }
                if (temp < count) {
                    temp = count;
                }
            }
            count = 1;
            for (int j = 1; j < N; j++) {
                if (copy[j][i].equals(copy[j-1][i])) {
                    count++;
                } else {
                    count = 1;
                }
                if (temp < count) {
                    temp = count;
                }
            }
        }
        return temp;
    }

    public static String[][] copy() {
        String[][] copy = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }

}
