import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100001;
    static int n, k;
    static int[] visited;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());

        bfs();
        System.out.println(visited[k] - 1);

    }

    private static void bfs() {
        visited = new int[MAX];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);
        visited[n] = 1;
        

        // x-1, x+1, x*2
        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (x - 1 >= 0 && x - 1 < MAX) {
                if (visited[x - 1] == 0) {
                    queue.offer(x-1);
                    visited[x-1] = visited[x] + 1;
                }
            }
            if (x + 1 >= 0 && x + 1 < MAX) {
                if (visited[x + 1] == 0) {
                    queue.offer(x+1);
                    visited[x+1] = visited[x] + 1;
                }
            }

            if (x * 2 >= 0 && x * 2 < MAX) {
                if (visited[x * 2] == 0) {
                    queue.offer(x*2);
                    visited[x*2] = visited[x] + 1;
                }
            }
        }
    }

}
