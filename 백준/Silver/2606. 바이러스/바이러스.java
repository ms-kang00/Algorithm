import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] list;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new LinkedList[n+1];


        for (int i = 1; i <= n; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        int result = bfs();
        
        bw.write(result + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
    
    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        q.offer(1);
        int count = 0;
        
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int next : list[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }
        }
        return count;
    }
}
