package 문제풀이.week4.민섭.boj_1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] ars) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int col = Integer.parseInt(br.readLine());

		
		while( col -->0)
		{
			int loop = Integer.parseInt(br.readLine());
			int number = loop;
			int[][] array = new int[loop][2];
			for(int i=0; i<loop; i++)
			{
				 StringTokenizer st = new StringTokenizer(br.readLine());
	             array[i][0] = Integer.parseInt(st.nextToken());
	             array[i][1] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<loop; i++)
			{
				for(int t=0; t<loop; t++)
				{
					if(array[i][0] > array[t][0])
					{
						if(array[i][1]> array[t][1])
						{
							number --;
							break;
						}
					}
					
				}
			}
			System.out.println(number);
		}
	}
}
