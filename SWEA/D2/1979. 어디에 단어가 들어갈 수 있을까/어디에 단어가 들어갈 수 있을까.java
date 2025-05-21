import java.io.*;
import java.util.*;

public class Solution {
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());


        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = 0;

            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1) {
                        count++;
                    } else {
                        if (count == k) {
                            result++;
                        }
                        count = 0;
                    }
                }
                if (count == k) {
                    result++;
                }
            }

            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int i = 0; i < n; i++) {
                    if (map[i][j] == 1) {
                        count++;
                    } else {
                        if (count == k) {
                            result++;
                        }
                        count = 0;
                    }
                }
                if (count == k) {
                    result++;
                }
            }
            bw.write("#" + test_case + " " + result + "\n");


        }
        bw.flush();
        bw.close();
    }

}