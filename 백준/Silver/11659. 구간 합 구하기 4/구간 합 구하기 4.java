import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 추가!
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        dp = new int[n + 1];

        String[] nums = br.readLine().split(" ");
        for (int k = 1; k <= n; k++) {
            arr[k] = Integer.parseInt(nums[k - 1]);
            dp[k] = dp[k - 1] + arr[k];
        }

        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            bw.write((dp[j] - dp[i - 1]) + "\n");
        }

        bw.flush();  // 꼭 버퍼 비우기!
        bw.close();  // 닫아주기!
    }
}