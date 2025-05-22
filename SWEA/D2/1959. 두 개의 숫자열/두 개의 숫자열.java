import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int max = 0;

            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            if (a.length > b.length) {
                int[] temp = a;
                a = b;
                b = temp;
            }

            for (int i = 0; i <= b.length - a.length; i++) {
                int sum = 0;
                for (int j = 0; j < a.length; j++) {
                    sum += a[j] * b[i + j];
                }
                max = Math.max(max, sum);
            }

            bw.write("#" + test_case + " " + max + "\n");
        }
        bw.flush();
        bw.close();
    }

}