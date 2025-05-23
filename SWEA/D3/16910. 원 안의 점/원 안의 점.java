import java.io.*;
import java.util.*;
 
public class Solution {
	static final int MIN = -500;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
           int n = Integer.parseInt(br.readLine());
           int count = 0;
           
          
           
           for (int x = n; x >= MIN; x--) {
        	   for (int y = n; y >= MIN; y--) {
        		   if ((x * x + y * y) <= n * n) {
        			   count++;
        		   }
        	   }
           }
           
           bw.write("#" + test_case + " " + count + "\n");
        }
 
        bw.flush();
        bw.close();
    }
}