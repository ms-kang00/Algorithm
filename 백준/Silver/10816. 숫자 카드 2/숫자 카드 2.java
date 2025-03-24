import java.io.*;
import java.util.*;

public class Main {
    static int N, M, temp;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] card_plus = new int[10000001];
        int[] card_minus = new int[10000001];

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            temp = Integer.parseInt(st.nextToken());
            if(temp >= 0)    card_plus[temp]++;
            else{
                temp *= -1;
                card_minus[temp]++;
            }
        }

        M = Integer.parseInt(br.readLine());
        
        StringTokenizer aa = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            temp = Integer.parseInt(aa.nextToken());
            if(temp >= 0)   bw.write(card_plus[temp] + " ");
            else{
                temp *= -1;
                bw.write(card_minus[temp] + " ");
            }
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}
