import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_S5_11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); 
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());  //입력받은 명령
			String s = st.nextToken();
			
			if(s.equals("add")) {
				set.add(st.nextToken());
				continue;
			}
			else if(s.equals("remove")) {
				set.remove(st.nextToken()); 
				continue;
			}
			else if(s.equals("check")) {
				if(set.contains(st.nextToken())) sb.append("1\n");
				else sb.append("0\n");
				continue;
			}
			else if(s.equals("toggle")) {
				String togNum =  st.nextToken();
				if(set.contains(togNum)) set.remove(togNum);
				else set.add(togNum);
				continue;
			}
			else if(s.equals("all")){
				set.clear();
				for(int i=1;i<=20;i++) {
					String s1 = Integer.toString(i);
					set.add(s1);
				}
				continue;
			}
			else if(s.equals("empty")) set.clear();
			
		}
		System.out.println(sb.toString());
	}
}
