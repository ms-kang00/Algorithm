import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int max;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
                checkTShape(i, j);
            }
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
    
    }

    static void dfs(int x, int y, int depth, int sum) {
        Point p = new Point(x, y);
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int curX = p.x + dx[i];
            int curY = p.y + dy[i];

            if (curX >= 0 && curY >= 0 && curX < n && curY < m && !visited[curX][curY]) {
                visited[curX][curY] = true;
                dfs(curX, curY, depth + 1, sum + map[curX][curY]);
                visited[curX][curY] = false;
            }
        }


    }

    static void checkTShape(int x, int y) {
        Point p = new Point(x, y);

        for (int i = 0; i < 4; i++) {
            int sum = map[p.x][p.y];
            boolean range = true;
            for (int j = 0; j < 3; j++) {
                int dir = (i+j) % 4;
                int curX = p.x + dx[dir];
                int curY = p.y + dy[dir];

                if (curX < 0 || curY < 0 || curX >= n || curY >= m) {
                    range = false;
                    break;
                }

                sum += map[curX][curY];
            }

            if (range) {
                max = Math.max(max, sum);
            }
        }
    }
}
