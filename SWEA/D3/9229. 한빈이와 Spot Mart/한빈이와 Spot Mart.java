import java.util.*;
import java.io.*;

public class Solution {
	static int[] weight;
	static int N, M, max;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            weight = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
            	weight[i] = Integer.parseInt(st.nextToken());
            }
            
            max = -1;
            dfs(0, 0, 0);
            System.out.println("#" + test_case + " " + max);
        }
    }
    static void dfs(int index, int count, int sum) {
    	if (sum > M) {
    		return;
    	}
    	
    	if (count == 2) {
    		max = Math.max(max, sum);
    		return;
    	}
    	
    	if (index == N) {
    		return;
    	}
    	
    	dfs(index + 1, count + 1, sum + weight[index]);
    	
    	dfs(index + 1, count, sum);
    }
    
}