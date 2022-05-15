import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static int MAX = Integer.MIN_VALUE;	
	public static int MIN = Integer.MAX_VALUE;	
	static int[] num_arr, op_arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        num_arr = new int[N];
        op_arr = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int n=0;n<N;n++) {
        	num_arr[n]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) {
        	op_arr[i] = Integer.parseInt(st.nextToken());
        }

        
        dfs(num_arr[0], 1);
        
		System.out.println(MAX);
		System.out.println(MIN);
 
	}
 
	public static void dfs(int num, int idx) {
		if (idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
 
		for (int i = 0; i < 4; i++) {
			if (op_arr[i] > 0) {
 
				op_arr[i]--;
 
				switch (i) {
 
				case 0:	dfs(num + num_arr[idx], idx + 1);	break;
				case 1:	dfs(num - num_arr[idx], idx + 1);	break;
				case 2:	dfs(num * num_arr[idx], idx + 1);	break;
				case 3:	dfs(num / num_arr[idx], idx + 1);	break;
 
				}
				op_arr[i]++;
			}
		}
	}
 
}
