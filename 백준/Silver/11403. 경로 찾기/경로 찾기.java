import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] graph;
    static int[][] result;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        result = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            bfs(i);
        }

        for (int[] row : result) {
            for (int val : row) {
                bw.write(val + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    
    }

    static void bfs(int start) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next = 0; next < n; next++) {
                if (graph[cur][next] == 1 && !visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    result[start][next] = 1;
                }
            }
        }
    }
}
