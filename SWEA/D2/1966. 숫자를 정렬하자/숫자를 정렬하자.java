import java.io.*;
import java.util.*;

public class Solution {
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());

		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			bw.write("#" + test_case + " ");
			for (int i = 0; i < n; i++) {
				bw.write(arr[i] + " ");
			}
			bw.write("\n");
			
		}
		bw.flush();
		bw.close();
	}
	
	
}
