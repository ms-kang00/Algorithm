import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int max;
    

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                checkShape(i, j);
            }
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
    
    }

    static void checkShape(int x, int y) {
        // - 모양
        if (y + 3 < m) {
            max = Math.max(max, map[x][y] + map[x][y+1] + map[x][y+2] + map[x][y+3]);
        }

        // | 모양
        if (x + 3 < n) {
            max = Math.max(max, map[x][y] + map[x+1][y] + map[x+2][y] + map[x+3][y]);
        }

        // ㅁ 모양
        if (x + 1 < n && y + 1 < m) {
            max = Math.max(max, map[x][y] + map[x+1][y] + map[x][y+1] + map[x+1][y+1]);
        }

        // L 모양
        if (x + 2 < n && y + 1 < m) {
            max = Math.max(max, map[x][y] + map[x+1][y] + map[x+2][y] + map[x+2][y+1]);
        }

        // ㄱ 반대 모양
        if (x + 1 < n && y + 2 < m) {
            max = Math.max(max, map[x+1][y] + map[x][y] + map[x][y+1] + map[x][y+2]);
        }

        // ㄱ 모양
        if (x + 1 < n && y + 2 < m) {
            max = Math.max(max, map[x][y] + map[x][y+1] + map[x][y+2] + map[x+1][y+2]);
        }

        // L 반대 모양
        if (x + 2 < n && y - 1 >= 0) {
            max = Math.max(max, map[x][y] + map[x+1][y] + map[x+2][y] + map[x+2][y-1]);
        }

        if (x + 1 < n && y + 2 < m) {
            max = Math.max(max, map[x+1][y] + map[x+1][y+1] + map[x+1][y+2] + map[x][y+2]);
        }

        // ㄴ 모양
        if (x + 1 < n && y + 2 < m) {
            max = Math.max(max, map[x][y] + map[x+1][y] + map[x+1][y+1] + map[x+1][y+2]);
        }

        // ㄱ(세로가 더 긴) 방향
        if (x + 2 < n && y - 1 >= 0) {
            max = Math.max(max, map[x][y-1] + map[x][y] + map[x+1][y] + map[x+2][y]);
        }

        if (x + 2 < n && y + 1 < m) {
            max = Math.max(max, map[x][y] + map[x+1][y] + map[x+2][y] + map[x][y+1]);
        }

        // z 모양 1
        if (x + 2 < n && y + 1 < m) {
            max = Math.max(max, map[x][y] + map[x+1][y] + map[x+1][y+1] + map[x+2][y+1]);
        }

        // z 모양 2
        if (x + 2 < n && y + 1 < m) {
            max = Math.max(max, map[x+2][y] + map[x+1][y] + map[x+1][y+1] + map[x][y+1]);
        }

        // z 모양 3
        if (x + 1 < n && y + 2 < m) {
            max = Math.max(max, map[x][y] + map[x][y+1] + map[x+1][y+1] + map[x+1][y+2]);
        }

        // z 모양 4
        if (x + 1 < n && y + 2 < m) {
            max = Math.max(max, map[x+1][y] + map[x+1][y+1] + map[x][y+1] + map[x][y+2]);
        }

        // T 모양 1
        if (x + 1 < n && y + 2 < m) {
            max = Math.max(max, map[x][y] + map[x][y+1] + map[x][y+2] + map[x+1][y+1]);
        }

        // T 모양 2
        if (x + 1 < n && y + 2 < m) {
            max = Math.max(max, map[x][y+1] + map[x+1][y+1] + map[x+1][y] + map[x+1][y+2]);
        }

        // T 모양 3
        if (x + 2 < n && y + 1 < m) {
            max = Math.max(max, map[x+1][y] + map[x+1][y+1] + map[x][y+1] + map[x+2][y+1]);
        }

        // T 모양 4
        if (x + 2 < n && y + 1 < m) {
            max = Math.max(max, map[x][y] + map[x+1][y] + map[x+2][y] + map[x+1][y+1]);
        }
     }
}
