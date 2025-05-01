import java.io.*;
import java.util.*;

public class Main {
    static int n, r, c;
    static int result;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2, n);
        divide(0, 0, size);

        bw.write(result + "\n");
        
        bw.flush();
        bw.close();
    
    }

    static void divide(int y, int x, int size) {
        if (size == 1) return;

        int half = size / 2;
        int block = half * half;

        if (r < y + half && c < x + half) {
            divide(y, x, half);
        } else if (r < y + half && c >= x + half) {
            result += block;
            divide(y, x + half, half);
        } else if (r >= y + half && c < x + half) {
            result += block * 2;
            divide(y + half, x, half);
        } else if (r >= y + half && c >= x + half) {
            result += block * 3;
            divide(y + half, x + half, half);
        }
    }
}
