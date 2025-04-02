import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // 정렬
        for (int i = 0; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // dfs
        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");

        // bfs
        visited = new boolean[N+1];
        bfs(V);

        bw.write(sb + "\n");
        
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int V) {
        visited[V] = true;
        sb.append(V).append(" ");

        for (int next : graph[V]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int v = q.poll();
            sb.append(v).append(" ");
            for (int next : graph[v]) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
