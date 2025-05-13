import java.io.*;
import java.util.*;

public class Solution
{
    static int[][] map;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            int center = n / 2;
            int sum = 0;
            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }
            
            /*for (int i = 0; i < n; i++) {
                int start, end;
                if (i <= center) {
                    start = center - i;
                    end = center + i;
                } else {
                    start = i - center;
                    end = n - (i - center) - 1;
                }
                for (int j = start; j <= end; j++) {
                    sum += map[i][j];
                }
            }*/

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                   if (Math.abs(i - center) + Math.abs(j - center) <= center) {
                        sum += map[i][j];
                    }
                }
            }
            
            bw.write("#" + test_case + " " + sum + "\n");
        }
        bw.flush();
        bw.close();
    }

}