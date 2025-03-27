import java.io.*;
import java.util.*;

public class Main {
    
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        if (N==1) {
            bw.write(1+"\n");
            bw.flush();
            return;
        }

        int layer = 1;
        int lastNum = 2;
        //2층: 2~7, 3층: 8~19, 4층: 20~37
        while (lastNum <= N) {
            lastNum += 6 * layer;
            layer++;
        }
        bw.write(layer+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
