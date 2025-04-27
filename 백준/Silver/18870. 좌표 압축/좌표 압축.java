import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] map;
    static Set<Integer> set = new HashSet<>();
    static Map<Integer, Integer> comp = new HashMap<>();
    

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        map = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            m = Integer.parseInt(st.nextToken());
            map[i] = m;
            set.add(m);
        }
        
        List<Integer> list = new ArrayList<>(set);
        list.sort(null);

        for (int i = 0; i < list.size(); i++) {
            comp.put(list.get(i), i);
        }
        
        for (int i : map) {
            bw.write(comp.get(i) + " ");
        }

        

        bw.flush();
        bw.close();
    }

}
