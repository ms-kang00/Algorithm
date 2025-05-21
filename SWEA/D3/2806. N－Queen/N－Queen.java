import java.io.*;
import java.util.*;

public class Solution {
    static int[] col;
    static int n, count;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = Integer.parseInt(br.readLine());
            count = 0;
            col = new int[n];
            dfs(0);
            bw.write("#" + test_case + " " + count + "\n");
        }
        bw.flush();
        bw.close();
    }
    static void dfs(int row) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            col[row] = i;
            boolean isValid = true;

            for (int j = 0; j < row; j++) {
                if (col[j] == col[row] || Math.abs(col[row] - col[j]) == row - j) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                dfs(row + 1);
            }
        }
    }
}