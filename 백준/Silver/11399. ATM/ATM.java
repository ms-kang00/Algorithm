import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        int sum = 0;
        int totalSum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            totalSum += sum;
        }

        bw.write(totalSum + "\n");
        
        
        bw.flush();
        br.close();
        bw.close();
    }
}
