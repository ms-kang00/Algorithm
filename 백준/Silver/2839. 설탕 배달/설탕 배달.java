import java.io.*;
import java.util.*;

public class Main {
    
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        while (N >= 0) {
            if (N % 5 == 0) {
                count += N / 5;
                bw.write(count + "\n");
                break;
            }
            N -= 3;
            count++;
        }
        if (N < 0) {
            bw.write(-1 + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
