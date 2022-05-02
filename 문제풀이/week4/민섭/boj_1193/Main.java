package 문제풀이.week4.민섭.boj_1193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] ars) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		
		int number = 1 ; // 해당 원소 개수
		int prev_number = 0; // 직전까지 원소 개수 합
		
		while(true)
		{
			if(x <= prev_number + number)
			{
				if(number % 2 == 1)
				{
					System.out.println((number - (x-prev_number-1)) + "/" + (x-prev_number));
					break;
				}
				else
				{
					System.out.println((x-prev_number) + "/" + (number - (x - prev_number-1)));
					break;
				}
			}
			else
			{
				prev_number += number;
				number ++;
			}
		}
	}

}
