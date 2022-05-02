package 문제풀이.week4.규정.boj_1193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String args[])throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int X=Integer.parseInt(br.readLine());
		int n=0;
		int top=1;
		int bot=1;
		int cnt=0;
		if(X==1) 
		{
			System.out.println("1/1");
		}
		else 
		{
			while(cnt<X){
				n++;
				cnt=n*(n+1)/2; //몇번 째 그룹인지 찾는 공식
			}
			int num= X - (n-1)*n/2;  //그룹에서 몇번 째 값인지 찾는 코드
			
			//그룹안에 분수들은  분모분자 합이 같다.
			if(n%2==0) {  //짝수 그룹  분자가 커짐
				top=num;
				bot=n-num+1;
			}else {  //홀수그룹  분모가커짐
				top=n-num+1;
				bot=num;                  //  X = 5         3번쨰그룹의  2번째      5-2+1 = 4  / 2
			}
			System.out.println(top+"/"+bot);
		}
		
	}
}


