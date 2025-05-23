import java.io.*;
import java.util.*;

public class Solution {
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int[] divided = {2, 3, 5, 7, 11};
		int[] result = new int[5];
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < divided.length; i++) {
				int count = 0;
				while (n % divided[i] == 0) {
					n /= divided[i];
					count++;
				}
				result[i] = count;
			}
			
			bw.write("#" + test_case + " ");
			for (int i = 0; i < result.length; i++) {
				bw.write(result[i] + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}

}
