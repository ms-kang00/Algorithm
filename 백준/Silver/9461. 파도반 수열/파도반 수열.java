import java.io.*;
import java.util.*;

public class Main {
    static int t, n;
    static long[] dp = new long[101];
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i < 101; i++) {
            dp[i] = dp[i-3] + dp[i-2];
        }

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }


        bw.flush();
        bw.close();
    }

}
