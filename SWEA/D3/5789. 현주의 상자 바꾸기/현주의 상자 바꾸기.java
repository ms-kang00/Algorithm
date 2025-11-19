import java.util.*;
import java.io.*;

public class Solution {
	static int[] box;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            
            box = new int[N + 1];
            for (int i = 0; i < Q; i++) {
            	st = new StringTokenizer(br.readLine());
            	int L = Integer.parseInt(st.nextToken());
            	int R = Integer.parseInt(st.nextToken());
            	
            	for (int j = L; j <= R; j++) {
            		box[j] = i + 1;
            	}
            }
            
            System.out.print("#" + test_case + " ");
            for (int i = 1; i < box.length; i++) {
            	System.out.print(box[i] + " ");
            }
            System.out.println();
        }
    }
    
    
}