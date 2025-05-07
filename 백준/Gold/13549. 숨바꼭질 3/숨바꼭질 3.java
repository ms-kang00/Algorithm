import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100001;
    static int n, k;
    static int[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        
        bw.write(visited[k] - 1 + "\n"); 
        bw.flush();
    }

    static void bfs() {
        visited = new int[MAX];
        Deque<Integer> q = new ArrayDeque<>();
        q.offerFirst(n);
        visited[n] = 1;

        while (!q.isEmpty()) {
            int x = q.pollFirst();

            if (2 * x >= 0 && 2 * x < MAX) {
                if (visited[2*x] == 0) {
                    q.offerFirst(2*x);
                    visited[2*x] = visited[x];
                }
            }

            if (x - 1 >= 0 && x - 1 < MAX) {
                if (visited[x-1] == 0) {
                    q.offerLast(x-1);
                    visited[x-1] = visited[x] + 1;
                }
            }

            if (x + 1 >= 0 && x + 1 < MAX) {
                if (visited[x+1] == 0) {
                    q.offerLast(x+1);
                    visited[x+1] = visited[x] + 1;
                }
            }

        }
    }
}
