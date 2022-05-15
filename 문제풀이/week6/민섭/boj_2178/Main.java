package 문제풀이.week6.민섭.boj_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int [][]i2;
	static int N;
	static int M;
	static boolean[][] visted;
	static int [][]check = {{-1 , 0}, {0 , -1}, {1 , 0}, {0 , 1}};
	public static class Sell
	{
		int x;
		int y;
		public Sell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] ars) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] operator1 = br.readLine().split(" ");
		N = Integer.parseInt(operator1[0]);
		M = Integer.parseInt(operator1[1]);
		
		i2 = new int[N][M];
		visted = new boolean[N][M];
		for ( int a =0; a<N; a++)
		{
			String[] operator = br.readLine().split("");
			for(int b=0; b<M; b++)
			{
				i2[a][b] = Integer.parseInt(operator[b]);
				visted[a][b] = false;
			}
		}
		bfs(0,0);
		System.out.println(i2[N-1][M-1]);
	}
	static void bfs(int x, int y)
	{
		Queue<Sell> q = new LinkedList<>();
		q.offer(new Sell(x,y));
		visted[x][y] = true;
		
		while(!q.isEmpty())
		{
			Sell p = q.poll();
			for(int a=0; a<4; a++)
			{
				int dx = p.x + check[a][0];
				int dy = p.y + check[a][1];
				
				if(dx <0 || dx >= N || dy <0 || dy>= M)
					continue;
				if(visted[dx][dy] == true || i2[dx][dy] == 0)
					continue;
				if(i2[dx][dy] == 1 && visted[dx][dy] == false)
				{
					q.offer(new Sell(dx,dy));
					i2[dx][dy] = i2[p.x][p.y] +1;
					visted[dx][dy] = true;
				}
			}
		}
	}
}
