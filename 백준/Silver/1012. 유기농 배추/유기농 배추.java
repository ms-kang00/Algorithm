import java.io.*;
import java.util.*;

public class Main {
    static int t, m, n, k;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;

    static List<Integer> list = new ArrayList<>();
    
    static class Point {
        int x, y;
        
        public Point(int x , int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        


        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[b][a] = 1;
            }

            for (int y = 0; y < n; y++) {
                for (int u = 0; u < m; u++) {
                    if (visited[y][u] == false && map[y][u] == 1) {

                        bfs(y, u);
                    }
                }
            }
            

            bw.write(list.size() + "\n");
            list.clear();
        }

        
        

        br.close();
        bw.flush();
        bw.close();
    }
    
    private static void bfs(int x, int y) {
        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        int count = 1;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int curX = p.x + dx[i];
                int curY = p.y + dy[i];

                if (isInBound(curX, curY) && !visited[curX][curY] && map[curX][curY] == 1) {
                    count++;
                    q.offer(new Point(curX, curY));
                    visited[curX][curY] = true;
                }
            }
        }
        list.add(count);
    }

    private static boolean isInBound(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
