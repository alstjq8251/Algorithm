package 문제풀이.week5.민섭.boj_4673;

public class Main {
    public static void main(String[] args) {
 
        boolean [] a = new boolean[10001];     
 
        for (int i = 1; i<10001; i++) {
            int n = d(i);
 
            if (n < 10001)             
                a[n] = true;
        }
            for (int i = 1; i < 10001; i++) {   
                if (a[i]==false) 
                    System.out.println(i);
            }
 
    }
    public static int d(int n){
        int sum = n;
        while (n != 0){ 
            sum += n%10;                   
            n /= 10;             
        }
        return sum;                             
    }
}
