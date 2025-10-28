import java.io.*;

public class Solution
{
    static int N, result;
    static boolean[] colCheck;
    static boolean[] dialog1;
    static boolean[] dialog2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            colCheck = new boolean[N];
            dialog1 = new boolean[2 * N];
            dialog2 = new boolean[2 * N];

            result = 0;

            dfs(0);
            System.out.println("#" + test_case + " " + result);
        }

    }

    static void dfs(int row) {
        if (row == N) {
            result++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (colCheck[col] || dialog1[row + col]
                    || dialog2[row - col + N]) {
                continue;
            }

            colCheck[col] = true;
            dialog1[row + col] = true;
            dialog2[row - col + N] = true;

            dfs(row + 1);

            colCheck[col] = false;
            dialog1[row + col] = false;
            dialog2[row - col + N] = false;
        }
    }

}
