import java.io.*;
import java.util.*;

public class Solution {
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[10];
			for (int i = 0; i < 10; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				list.add(arr[i]);
			}
			
			list.sort(null);
			
			int size = 0;
			long average = 0;
			
			for (int i = 1; i < list.size() -1 ; i++) {
				size += list.get(i);
			}
			
			average = Math.round((double) size / (list.size() - 2));
			bw.write("#" + test_case + " " + average + "\n");

		}
		
		bw.flush();
		bw.close();
	}

}
