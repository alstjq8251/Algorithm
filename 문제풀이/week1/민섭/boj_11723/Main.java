package 문제풀이.week1.민섭.boj_11723;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
	
	static HashSet<Integer> set1 = new HashSet<>();
	
	public static void main(String []ars) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int loop = Integer.parseInt(br.readLine());
		
		while(loop -->0)
		{
			String [] n = br.readLine().split(" ");
			String s = n[0];
			if(n.length != 1)
			{
				int n1 = Integer.parseInt(n[1]);
				
				if (s.equals("add")) {
					add(n1);
				}
				else if (s.equals("remove")) {
					remove(n1);
				}
				else if (s.equals("check")) {
					bw.write(check(n1) + "\n");
				}
				else if (s.equals("toggle")) {
					toggle(n1);
				}
			}
			else 
			{
				if(s.equals("all")) {
				all();
				}
				else if (s.equals("empty")) {
					empty();
				}
			}
		}
		
		bw.flush();
		bw.close();
		
	}
	
	private static void add(int sum ) {
		set1.add(sum);
	}

	private static void remove(int num) {
		if(set1.contains(num))
			set1.remove(num);
	}
	
	private static int check(int sum) {
		if(set1.contains(sum))
			return 1;
		else 
			return 0;
	}
	
	private static void toggle(int sum) {
		if(set1.contains(sum))
		{
			set1.remove(sum);
		}
		else set1.add(sum);
	}
	
	private static void all() {
		for(int i=1; i<21; i++)
			set1.add(i);
	}
	
	private static void empty() {
		set1.clear();
	}
	
}

