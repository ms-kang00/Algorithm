import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int white, blue;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, n);

        bw.write(white + "\n" + blue + "\n");
        
        bw.flush();
        bw.close();
    
    }


    static void divide(int x, int y, int size) {
        if (checkColor(x, y, size)) {
            if (map[x][y] == 0) white++;
            else blue++;
            return;
        }
        int newSize = size / 2;
        divide(x, y, newSize);
        divide(x + newSize, y, newSize);
        divide(x, y + newSize, newSize);
        divide(x + newSize, y + newSize, newSize);
    }

    static boolean checkColor(int x, int y , int size) {
        int color = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
