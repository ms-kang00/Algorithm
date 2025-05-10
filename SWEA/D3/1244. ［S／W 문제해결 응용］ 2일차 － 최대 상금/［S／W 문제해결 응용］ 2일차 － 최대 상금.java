import java.io.*;
import java.util.*;

public class Solution
{
    static long max;
    static int change;
    static Set<String> visited;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            max = 0;
            visited = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            change = Integer.parseInt(st.nextToken());

            dfs(num, 0);
            bw.write("#" + test_case + " " + max + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(String num, int count) {
        String key = num + " " + count;
        if (visited.contains(key)) return;
        visited.add(key);

        if (count == change) {
            max = Math.max(max, Long.parseLong(num));
            return;
        }


        char[] arr = num.toCharArray();

        for (int i = 0; i < num.length() - 1; i++) {
            for (int j = i + 1; j < num.length(); j++) {
                swap(arr, i, j);
                dfs(String.valueOf(arr), count + 1);
                swap(arr, i, j);
            }
        }
    }

    static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}