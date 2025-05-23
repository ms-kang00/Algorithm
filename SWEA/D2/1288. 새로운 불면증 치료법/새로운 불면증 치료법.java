import java.io.*;
import java.util.*;

public class Solution {
	static boolean[] seen;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
			seen = new boolean[10];
			int count = 0;
			int result = 1;
			
			while (true) {
				int a = n * result;
				String str = String.valueOf(a);
				
				for (char c : str.toCharArray()) {
					int digit = c - '0';
					
					if (!seen[digit]) {
						seen[digit] = true;
						count++;
					}
					
				}
				if (count == 10) break;
				result++;
			}
			
			bw.write("#" + test_case + " " + n * result + "\n");

		}
		
		bw.flush();
		bw.close();
	}

}
