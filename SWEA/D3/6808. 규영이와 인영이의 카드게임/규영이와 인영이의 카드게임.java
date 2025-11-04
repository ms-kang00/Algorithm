import java.io.*;
import java.util.*;

public class Solution {
    static int[] gyuCards, inCards;
    static int[] random;
    static boolean[] visited;
    static int winCount, loseCount;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            gyuCards = new int[9];
            inCards = new int[9];
            random = new int[9];
            visited = new boolean[9];

            boolean[] check = new boolean[19];
            for (int i = 0; i < 9; i++) {
                gyuCards[i] = Integer.parseInt(st.nextToken());
                check[gyuCards[i]] = true;
            }

            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (!check[i]) {
                    inCards[idx++] = i;
                }
            }
            winCount = 0;
            loseCount = 0;
            dfs(0);
            System.out.println("#" + test_case + " " + winCount + " " + loseCount);
        }
    }

    static void dfs(int round) {

        if (round == 9) {
            int gyuScore = 0, inScore = 0;

            for (int i = 0; i < 9; i++) {
                int sum = gyuCards[i] + random[i];
                if (gyuCards[i] > random[i]) {
                    gyuScore += sum;
                } else if (gyuCards[i] < random[i]) {
                    inScore += sum;
                }
            }

            if (gyuScore > inScore) {
                winCount++;
            } else {
                loseCount++;
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;

                random[round] = inCards[i];

                dfs(round + 1);

                visited[i] = false;
            }
        }
    }
}
