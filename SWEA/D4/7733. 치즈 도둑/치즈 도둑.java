import java.io.*;
import java.util.*;

public class Solution
{
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            int maxDay = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxDay = Math.max(maxDay, map[i][j]);
                }
            }

            int maxCheeseLump = 0;
            for (int day = 0; day <= maxDay; day++) {
                visited = new boolean[N][N];
                int cheeseLumpCount = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] > day && !visited[i][j]) {
                            cheeseLumpCount++;
                            dfs(i, j, day);
                        }
                    }
                }
                maxCheeseLump = Math.max(maxCheeseLump, cheeseLumpCount);
            }

            System.out.println("#" + test_case + " " + maxCheeseLump);
        }
    }

    static void dfs(int i, int j, int day) {
        Queue<Point> queue = new ArrayDeque<>();
        visited[i][j] = true;
        queue.offer(new Point(i, j));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (map[nx][ny] > day && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
