import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dp;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dp = new int[1001];

        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        for (int i = 4; i < 1001; i++) {
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
        }

        bw.write(dp[n] + "\n");
        

        bw.flush();
        bw.close();
    }

}
