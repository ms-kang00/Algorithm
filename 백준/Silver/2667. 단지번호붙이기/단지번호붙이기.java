import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer> list = new ArrayList<>();
    static boolean[][] visited;
    static int[][] map;
    static int[] xPos = {-1, 0, 1, 0};
    static int[] yPos = {0, -1, 0, 1};
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



        n = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= n; j++) {
                map[i][j] = line.charAt(j-1) - '0';
            }
        }
        visited = new boolean[n+1][n+1];
        bfs();

        printCount(bw);

        br.close();
        bw.flush();
        bw.close();
    }
    
    static void bfs() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    Queue<Point> q = new LinkedList<>();
                    visited[i][j] = true;
                    q.offer(new Point(i,j));
                    int count = 1;
    
                    while (!q.isEmpty()) {
                        Point p = q.poll();
                        
                        for (int k = 0; k < 4; k++) {
                            int curX = p.x + xPos[k];
                            int curY = p.y + yPos[k];
    
                            if (curX > 0 && curY > 0 && curX <= n && curY <= n && !visited[curX][curY] && map[curX][curY] == 1) {
                                visited[curX][curY] = true;
                                q.offer(new Point(curX, curY));
                                count++;
                            }
    
                        }
                    }
                    list.add(count);
                }
            }
        }
    }

    static void printCount(BufferedWriter bw) throws IOException{
        bw.write(list.size() + "\n");
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + "\n");
        }
    }
}
