import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];

            map[0][0] = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = map[i-1][j] + map[i-1][j-1];
                    }
                }
            }

            bw.write("#" + test_case + "\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    bw.write(map[i][j] + " ");
                }
                bw.write("\n");
            }

        }
        bw.flush();
        bw.close();
    }

}