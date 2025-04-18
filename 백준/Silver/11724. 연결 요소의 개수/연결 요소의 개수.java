import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] list;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];

        for (int k = 1; k <= n; k++) {
            list[k] = new ArrayList<>();
        }
        visited = new boolean[n+1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        int count = 0;

        for (int j = 1; j <= n; j++) {
            if (!visited[j]) {

                dfs(j);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int element) {
        visited[element] = true;
        for (int next : list[element]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
