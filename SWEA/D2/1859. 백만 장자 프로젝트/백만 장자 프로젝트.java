import java.io.*;
import java.util.*;

public class Solution
{
    static int n;
    static int[] prices;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = Integer.parseInt(br.readLine());
            prices = new int[n];
            int maxPrice = 0;
            long result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = n-1; i >= 0; i--) {
                if (maxPrice < prices[i]) {
                    maxPrice = prices[i];
                } else {
                    result += maxPrice - prices[i];
                }
            }
            bw.write("#" + test_case + " " + result + "\n");
        }
        bw.flush();
        bw.close();
    }


}