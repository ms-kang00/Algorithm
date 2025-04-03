import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] nearX = {-1, 0, 1, 0};
    static int[] nearY = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = line.charAt(j-1) - '0';
            }
        }
        bfs();

        bw.write(map[n][m] + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(1,1));
        visited[1][1] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int curY = p.y + nearY[i];
                int curX = p.x + nearX[i];
                if (curY > 0 && curX > 0 && curY <= n && curX <= m && map[curY][curX] != 0 && visited[curY][curX] == false) {
                    q.offer(new Point(curX, curY));
                    map[curY][curX] = map[p.y][p.x] + 1;
                    visited[curY][curX] = true;
                 }
            }
        }
    }
}
