import java.io.*;
import java.util.*;

public class Solution {
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static class Point implements Comparable<Point> {
        int x, y, cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }
    

    public static void main(String[] args) throws Exception {
        

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T;
		T=Integer.parseInt(br.readLine());
        int[][] map;
        int[][] result;

		for(int test_case = 1; test_case <= T; test_case++)
		{


            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            result = new int[n][n];

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = line.charAt(j) - '0';
                    result[i][j] = Integer.MAX_VALUE;
                }
            }

            int value = bfs(result, map);

            bw.write("#" + test_case + " " + value + "\n");
            bw.flush();
		}
    
    }

    static int bfs(int[][] result, int[][] map) {
        Queue<Point> q = new PriorityQueue<>();
        q.offer(new Point(0, 0, 0));
        result[0][0] = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
                    
                    int sumCost = result[p.x][p.y] + map[nextX][nextY];

                    if (sumCost < result[nextX][nextY]) {
                        result[nextX][nextY] = sumCost;
                        q.offer(new Point(nextX, nextY, sumCost));
                    }
                }
            }
        }

        return result[n-1][n-1];
    }

}
