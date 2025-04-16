import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] stairs;
    static int[] dp;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        stairs = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.print(stairs[0] + "\n");
            return;
        }

        if (n == 2) {
            System.out.print(stairs[0] + stairs[1] + "\n");
            return;
        }

        dp[0] = stairs[0];
        dp[1] = stairs[0] + stairs[1];
        dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i];
        }

        System.out.print(dp[n-1] + "\n");
    }
}
