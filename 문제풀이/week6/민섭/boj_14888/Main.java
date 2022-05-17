package 문제풀이.week6.민섭.boj_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int MAX = Integer.MIN_VALUE;    
    public static int MIN = Integer.MAX_VALUE;
	static int N;
	static int num[];
	static int operation[];
	
	public static void main(String[] ars) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int [N];
		String[] op = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(op[i]);
		}
		operation = new int [4];
		String[] op1 = br.readLine().split(" ");
		for (int i = 0; i < 4; i++) {
			operation[i] = Integer.parseInt(op1[i]);
		}
		
		abs(num[0],1);
		System.out.println(MAX);
		System.out.println(MIN);
	}
	
	public static void abs(int sum, int x)
	{
		if (x == N)
		{
			MAX = Math.max(sum, MAX);
			MIN = Math.min(sum, MIN);
			return;
		}
		for(int i=0; i<4; i++)
		{
			if(operation[i] > 0)
			{
				operation[i]--;
				switch(i)
				{
				case 0: abs(sum + num[x], x+1);
				break;
				case 1: abs(sum - num[x], x+1);
				break;
				case 2: abs(sum * num[x], x+1);
				break;
				case 3: abs(sum / num[x], x+1);
				break;
				}
				operation[i]++;
			}
		}
	}
}
