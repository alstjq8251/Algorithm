package 문제풀이.week5.규정.boj_1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] words_arr = new String[N];	
		for (int i = 0; i < N; i++) {
			words_arr[i] = br.readLine();
		}
		
		 
		Arrays.sort(words_arr, new Comparator<String>() {		
			@Override
			public int compare(String s1, String s2) {
			
				if(s1.length() == s2.length()){
					return s1.compareTo(s2);	
				}
				else {
					return Integer.compare(s1.length(), s2.length());
				}
			}
		});
		
 
		sb.append(words_arr[0]).append('\n');
		
		for (int i = 1; i < N; i++) {
			if (!words_arr[i].equals(words_arr[i - 1])) {
				sb.append(words_arr[i]).append('\n');
			}
		}
		System.out.println(sb);
	}
}
