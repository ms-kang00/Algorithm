import java.io.*;
import java.util.*;

public class Main {
    static int m, n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static List<Point> list = new ArrayList<>();

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        m = Integer.valueOf(st.nextToken());
        n = Integer.valueOf(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    list.add(new Point(i, j));
                }
            }
        }
        bfs(list);

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    System.out.println("-1");
                    return;
                }
                result = Math.max(result, map[i][j]);
            }
        }

        System.out.println(result - 1);
    }

    private static void bfs(List<Point> start) {
        Queue<Point> queue = new ArrayDeque<>();
        for (Point p : start) {
            queue.offer(p);
            visited[p.x][p.y] = true;
        }

        while (!queue.isEmpty()) {
                Point p = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int curX = p.x + dx[i];
                    int curY = p.y + dy[i];

                    if (curX >= 0 && curY >= 0 && curX < n && curY < m) {
                        if (map[curX][curY] == 0) {
                            map[curX][curY] = map[p.x][p.y] + 1;
                            queue.offer(new Point(curX, curY));
                        }
                    }
            }
        }
    }
}
