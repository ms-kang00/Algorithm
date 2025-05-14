import java.io.*;
import java.util.*;

public class Solution {
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            int count = 0;

            for (int i = 0; i < size; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < size; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < size; j++) {
                boolean check = false;
                for (int i = 0; i < size; i++) {
                    if (map[i][j] == 1) {
                        check = true;
                    } else if (map[i][j] == 2) {
                        if (check) {
                            count++;
                            check = false;
                        }
                    }
                }
            }

            bw.write("#" + test_case + " " + count + "\n");
        }
        bw.flush();
        bw.close();
    }
}