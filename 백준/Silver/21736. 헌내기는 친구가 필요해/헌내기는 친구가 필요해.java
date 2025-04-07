import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] xPos = {-1, 0, 1, 0};
    static int[] yPos = {0, -1, 0, 1};
    static char[][] map;
    static boolean[][] visited;
    static int startX, startY;

    static class Point {
        int x;
        int y;

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
        map = new char[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = line.charAt(j-1);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }


        bfs(startX, startY);
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    private static void bfs(int startX, int startY) {
        Queue<Point> q = new LinkedList<>();
        visited[startX][startY] = true;
        q.offer(new Point(startX, startY));
        int count = 0;
        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int curX = p.x + xPos[i];
                int curY = p.y + yPos[i];


                if (curX < 1 || curY < 1 || curX > n || curY > m) continue;
                if (visited[curX][curY] || map[curX][curY] == 'X') continue;
                visited[curX][curY]= true;

                if (map[curX][curY] == 'P') count++;
                q.offer(new Point(curX, curY));
            }
        }

        if (count == 0) {
            System.out.print("TT\n");
        } else {
            System.out.print(count + "\n");
        }
    }
}
