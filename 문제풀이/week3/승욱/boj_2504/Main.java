package 문제풀이.week3.승욱.boj_2504;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static String[] c;
    static int smallOpen = 0;
    static int smallClose = 0;
    static int largeOpen = 0;
    static int largeClose = 0;
    static int answer = 0;

    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        c = str.split("");

        if (factCheck()) {
            for (int i = 0; i < list.size(); i++) {
                answer += calculate(list.get(i));
            }
            System.out.println(answer);
        } else {
            System.out.println(0);
        }
    }

    public static boolean factCheck() {
        String s = "";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i].equals("(")) {
                stack.push("(");
                smallOpen++;
            } else if (c[i].equals(")")) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!stack.pop().equals("(")) {
                    return false;
                }
                smallClose++;
            } else if (c[i].equals("[")) {
                stack.push("[");
                largeOpen++;
            } else if (c[i].equals("]")) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!stack.pop().equals("[")) {
                    return false;
                }
                largeClose++;
            } else {
                return false;
            }
            s += c[i];
            if (smallClose > smallOpen || largeClose > largeOpen) {
                return false;
            } else if (smallClose == smallOpen && largeClose == largeOpen) {
                list.add(s);
                s = "";
            }
        }
        return true;
    }

    public static int calculate(String str) {
        String[] c = str.split("");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i].equals("(")) {
                stack.push("(");
            } else if (c[i].equals(")")) {
                String temp = stack.pop();
                if (temp.equals("(")) {
                    stack.push(String.valueOf(2));
                } else {
                    int a = Integer.parseInt(temp);
                    String ang = stack.pop();
                    while (!ang.equals("(")) {
                        a +=  Integer.parseInt(ang);
                        ang = stack.pop();
                    }
                    stack.push(String.valueOf(a * 2));
                }
            } else if (c[i].equals("[")) {
                stack.push("[");
            } else if (c[i].equals("]")) {
                String temp = stack.pop();
                if (temp.equals("[")) {
                    stack.push(String.valueOf(3));
                } else {
                    int a = Integer.parseInt(temp);
                    String ang = stack.pop();
                    while (!ang.equals("[")) {
                        a +=  Integer.parseInt(ang);
                        ang = stack.pop();
                    }
                    stack.push(String.valueOf(a * 3));
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
