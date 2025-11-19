import java.util.*;
import java.io.*;

public class Solution {

	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
             
            st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < K; i++) {
            	list.add(Integer.parseInt(st.nextToken()));
            }
            
            List<Integer> resultList = new ArrayList<>(); 
            boolean check = false;
            for (int i = 1; i <= N; i++) {
            	for (int j = 0; j < list.size(); j++) {
            		if (i != list.get(j)) {
            			check = true;           		
            		} else if (i == list.get(j)) {
            			check = false;
            			break;
            		}
            	
            	}
            	if (check) {
            		resultList.add(i);
            	}
            }
            resultList.sort(null);
            
            System.out.print("#" + test_case + " ");
            for (int i = 0; i < resultList.size(); i++) {
            	System.out.print(resultList.get(i) + " ");
            }
            System.out.println();
        }
    }
    
    
}