import java.io.*;
import java.util.*;

public class Solution
{
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str1 = st.nextToken();
            String str2 = st.nextToken();

            dp = new int[str1.length() + 1][str2.length() + 1];

            for (int i = 1; i <= str1.length(); i++) {
                for (int j = 1; j <= str2.length(); j++) {
                    char ch1 = str1.charAt(i - 1);
                    char ch2 = str2.charAt(j - 1);

                    if (ch1 == ch2) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            System.out.println("#" + test_case + " " + dp[str1.length()][str2.length()]);
        }
    }

}
