import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long minValue = Integer.MAX_VALUE;

            // 최소화
            for (int r = 1; r <= n; r++) {
                for (int c = 1; c <= n / r; c++) {
                    long value = (long) a * Math.abs(r-c) + b * (n - (long) r * c);
                    if (value < minValue) {
                        minValue = value;
                    }
                }
            }
            bw.write("#" + test_case + " " + minValue + "\n");
        }
        bw.flush();
        bw.close();
    }

}