import java.io.*;
import java.util.*;

public class Solution {
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            String[][] rot90 = new String[n][n];
            String[][] rot180 = new String[n][n];
            String[][] rot270 = new String[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    rot90[i][j] = Integer.toString(map[n - j - 1][i]);
                    rot180[i][j] = Integer.toString(map[n - i - 1][n - j - 1]);
                    rot270[i][j] = Integer.toString(map[j][n - i - 1]);
                }
            }

            bw.write("#" + test_case + "\n");
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(rot90[i][j]);
                }
                sb.append(" ");
                for (int j = 0; j < n; j++) {
                    sb.append(rot180[i][j]);
                }
                sb.append(" ");
                for (int j = 0; j < n; j++) {
                    sb.append(rot270[i][j]);
                }
                bw.write(sb.toString() + "\n");
            }


        }
        bw.flush();
        bw.close();
    }
}