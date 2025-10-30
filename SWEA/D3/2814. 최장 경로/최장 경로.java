import java.io.*;
import java.util.*;

public class Solution
{
    static int[][] graph;
    static int N, M;
    static int maxLength;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            graph = new int[N + 1][N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x][y] = 1;
                graph[y][x] = 1;
            }

            maxLength = 0;
            for (int i = 1; i <= N; i++) {
                visited = new boolean[N + 1];
                dfs(i, 1);
            }

            System.out.println("#" + test_case + " " + maxLength);
        }
    }

    static void dfs(int node, int length) {
        visited[node] = true;

        maxLength = Math.max(maxLength, length);

        for (int v = 1; v <= N; v++) {
            if (graph[node][v] == 1 && !visited[v]) {
                dfs(v, length + 1);
            }
        }

        visited[node] = false;
    }

}
