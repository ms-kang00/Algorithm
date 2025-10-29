import java.io.*;
import java.util.*;

public class Solution
{
    static int N, K, count;
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            sequence = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                sequence[i] = Integer.parseInt(st.nextToken());
            }

            count = 0;
            dfs(0, 0);
            System.out.println("#" + test_case + " " + count);
        }
    }

    static void dfs(int index, int curSum) {
        if (curSum > K) {
            return;
        }

        if (index == N) {
            if (curSum == K) {
                count++;
            }
            return;
        }


        dfs(index + 1, curSum + sequence[index]);

        dfs(index + 1, curSum);
    }
}
