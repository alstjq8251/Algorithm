package 문제풀이.week1.승욱.boj_11723;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());

        Set<String> result = new LinkedHashSet<>();
        for(int i=0; i < M; i++) {
            String s = br.readLine();
            String[] arr = s.split(" ");
            if (arr[0].equals("add")) {
                result.add(arr[1]);
            } else if (arr[0].equals("remove")) {
                result.remove(arr[1]);
            } else if (arr[0].equals("check")) {
                if (result.contains(arr[1])) {
                    wr.write(1 + "\n");
                } else {
                    wr.write(0 + "\n");
                }
            } else if (arr[0].equals("toggle")) {
                if (result.contains(arr[1])) {
                    result.remove(arr[1]);
                } else {
                    result.add(arr[1]);
                }
            } else if (arr[0].equals("all")) {
                result = setAll(result);
            } else if (arr[0].equals("empty")) {
                result = new LinkedHashSet<>();
            }
        }
        wr.flush();
        br.close();
        wr.close();
    }

    private static Set<String> setAll(Set<String> result) {
        result = new LinkedHashSet<>();
        for (int i = 1; i < 21; i++) {
            result.add(String.valueOf(i));
        }
        return result;
    }
}
