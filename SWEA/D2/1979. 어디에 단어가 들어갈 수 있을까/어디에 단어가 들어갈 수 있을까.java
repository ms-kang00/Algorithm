import java.io.*;
import java.util.*;

public class Solution
 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    sb.append(map[i][j]);
                }

                String[] parts = sb.toString().split("0");
                for (String part : parts) {
                    if (part.length() == K) {
                        result++;
                    }
                }
            }

            for (int j = 0; j < N; j++) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    sb.append(map[i][j]);
                }

                String[] parts = sb.toString().split("0");
                for (String part : parts) {
                    if (part.length() == K) {
                        result++;
                    }
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
}
