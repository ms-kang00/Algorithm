import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] map;
    static Set<Integer> set = new TreeSet<>();
    

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            m = Integer.parseInt(st.nextToken());
            map[i] = m;
            set.add(m);
        }
        
        int[] result = new int[set.size()];
        int count = 0;
        for (int i : set) {
            result[count] = i;
            count++;
        }

        for (int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(result, map[i]);
            bw.write(index + " ");
        }

        bw.flush();
        bw.close();
    }

}
