import java.io.*;
import java.util.*;

public class Main {
    static int n, m, h;
    static int[][][] tomato;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static boolean[][][] visited;
    static List<Point> list = new ArrayList<>();

    static class Point {
        int x, y, z;
        public Point(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        tomato = new int[h][m][n];
        visited = new boolean[h][m][n];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 1) {
                        list.add(new Point(i, j, k));
                    }
                }
            }
        }
        bfs();

        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (tomato[i][j][k] == 0) {
                        bw.write("-1\n");
                        bw.flush();
                        return;
                    }
                    result = Math.max(result, tomato[i][j][k]);
                }
            }
        }

        bw.write((result - 1) + "\n");

        bw.flush();
        bw.close();
    
    }

    static void bfs() {
        Queue<Point> q = new ArrayDeque<>();

        for (Point p : list) {
            q.offer(p);
            visited[p.z][p.x][p.y] = true;
        }

        while (!q.isEmpty()) {
            Point p = q.poll();
            
            for (int i = 0; i < 6; i++) {
                int curX = p.x + dx[i];
                int curY = p.y + dy[i];
                int curZ = p.z + dz[i];

                if (curX >= 0 && curY >= 0 && curZ >= 0 && curX < m && curY < n && curZ < h) {
                    if (tomato[curZ][curX][curY] == 0) {
                        tomato[curZ][curX][curY] = tomato[p.z][p.x][p.y] + 1;
                        visited[curZ][curX][curY] = true;
                        q.offer(new Point(curZ, curX, curY));
                    }
                }
            }
        }
    }
}
