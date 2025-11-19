import java.util.*;
import java.io.*;

public class Solution {
	static int[] student;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
             
            st = new StringTokenizer(br.readLine());
            student = new int[N + 1];
            for (int i = 0; i < K; i++) {
            	int d = Integer.parseInt(st.nextToken());
            	student[d] = 1;
            }
            
            System.out.print("#" + test_case + " ");
            for (int i = 1; i < student.length; i ++) {
            	if (student[i] == 0) {
            		System.out.print(i + " ");
            	}
            }
            System.out.println();
        }
    }
    
    
}