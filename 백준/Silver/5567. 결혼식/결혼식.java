import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> friends[];
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        friends = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int friend1 = Integer.parseInt(st.nextToken());
            int friend2 = Integer.parseInt(st.nextToken());
            friends[friend1].add(friend2);
            friends[friend2].add(friend1);
        }

        bfs();

    }

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 0});
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int person = cur[0];
            int depth = cur[1];

            if (depth >= 2) continue;

            for (int next : friends[person]) {
                isVisited(next, depth, q);
            }
        }
        System.out.println(count);
    }

    static void isVisited(int next, int depth, Queue<int[]> q) {
        if (!visited[next]) {
            visited[next] = true;
            count++;
            q.add(new int[]{next, depth+1});
        }
    }
}
