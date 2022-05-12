package 문제풀이.week5.민섭.boj_1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	public static void main(String[] ars) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int i = Integer.parseInt(br.readLine());
		String arr[]  = new String[i];
		
		for (int a = 0; a < i; a++) {
			arr[a] = br.readLine();
		}

		Arrays.sort(arr,new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return s1.length() - s2.length();
				}
			}
		});
		
		// 중복제거
		System.out.println(arr[0]);
		for (int b = 1; b < i; b++) {
			if (arr[b].equals(arr[b-1])) continue;
			System.out.println(arr[b]);
		}
	}
}
