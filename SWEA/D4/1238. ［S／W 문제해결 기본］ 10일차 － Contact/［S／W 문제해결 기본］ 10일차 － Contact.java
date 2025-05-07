
import java.io.*;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class Solution
{
    static int length, start;
    static int[][] graph;
    static boolean[] visited;
    static int[] depth;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            length = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            graph = new int[101][101];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < length / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from][to] = 1;
            }

            int result = bfs();
            bw.write("#" + test_case + " " + result + "\n");
        }
        bw.flush();
        bw.close();
    }

    static int bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        visited = new boolean[101];
        depth = new int[101];
        q.offer(start);
        visited[start] = true;

        int maxDepth = 0;
        int maxNode = start;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next = 1; next <= 100; next++) {
                if (graph[current][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    depth[next] = depth[current] + 1;
                    q.offer(next);

                    if (depth[next] > maxDepth) {
                        maxDepth = depth[next];
                        maxNode = next;
                    } else if (depth[next] == maxDepth && next > maxNode) {
                        maxNode = next;
                    }
                }
            }
        }
        return maxNode;
    }
}