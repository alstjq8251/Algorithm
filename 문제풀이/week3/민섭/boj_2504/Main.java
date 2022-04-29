package 문제풀이.week3.민섭.boj_2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException  {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int n = 0;
		int nt = 1;
		boolean check = true;
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
			char c;
			switch(ch) { 
			case '(' :
				stack.push(ch);
				nt *=2;
				break;
			case '[':
				stack.push(ch);
				nt *=3;
				break;
			case ')' : case ']':
				if(stack.isEmpty() || s.length() % 2 != 0)
				{
					check = false;
					break;
				}
				else {                                 
					c=stack.pop();
					if(ch == ')')
					{
						if(c == '(') 
						{
							if(s.charAt(i-1) == '(')
								n += nt;
							nt /= 2;
							break;
						}
						else 
						{
							check = false;
							break;
						}
					}
					else 
						{
						if(c == '[')
						{
							if(s.charAt(i-1) == '[')
								n += nt;
							nt /= 3;
							break;
						}
						else
						{
							check = false;
							break;
						}
					}
				}
				default:
					check = false;
			}
			if (check == false)
				break;
		}
		if(check == true)
			System.out.println(n);
		else
		{
			n=0;
			System.out.println(n);
		}
	}
}

