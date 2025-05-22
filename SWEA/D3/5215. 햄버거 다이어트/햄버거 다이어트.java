import java.io.*;
import java.util.*;

public class Solution {
    static int n, len, max;
    static int[] ingredient, calorie;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            len = Integer.parseInt(st.nextToken());
            max = 0;

            ingredient = new int[n];
            calorie = new int[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                ingredient[i] = Integer.parseInt(st.nextToken());
                calorie[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, 0);
            bw.write("#" + test_case + " " + max + "\n");
        }
        bw.flush();
        bw.close();
    }
    static void dfs(int index, int ingrediSum, int calSum) {
        if (calSum > len) return;

        if (index == n) {
            max = Math.max(max, ingrediSum);
            return;
        }

        dfs(index + 1, ingrediSum + ingredient[index], calSum + calorie[index]);

        dfs(index + 1, ingrediSum, calSum);
    }
}