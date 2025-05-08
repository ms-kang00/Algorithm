import java.io.*;
import java.util.*;

public class Solution
{
    static int[] buildings;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            buildings = new int[n];
            int sum = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int height = Integer.parseInt(st.nextToken());
                buildings[i] = height;
            }

            for (int i = 2; i < n - 2; i++) {
                int maxValue = Math.max(Math.max(buildings[i-2], buildings[i-1]), Math.max(buildings[i+1], buildings[i+2]));

                if (buildings[i] > maxValue) {
                    sum += buildings[i] - maxValue;
                }

            }
            bw.write("#" + test_case + " " + sum + "\n");
        }
        bw.flush();
        bw.close();
    }


}