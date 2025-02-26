import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int result = 0;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (isPrime(arr[i])) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static boolean isPrime(int prime) {
        if (prime == 1) {
            return false;
        }
        for (int i=2; i*i<=prime; i++) {
            if (prime % i == 0) {
                return false;
            }
        }
        return true;
    }
}