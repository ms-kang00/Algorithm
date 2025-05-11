import java.io.*;
import java.util.*;

public class Solution
{
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            int x = 0;
            int y = 0;
            int dir = 0;

            for (int i = 1; i <= n * n; i++) {
                map[x][y] = i;

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] != 0) {
                    dir = (dir + 1) % 4;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }

                x = nx;
                y = ny;
            }

            bw.write("#" + test_case + "\n");
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    bw.write(map[i][j] + " ");
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
    }

}