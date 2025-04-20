import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static Set<String> set = new HashSet<>();
    static List<String> list = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (int j = 0; j < m; j++) {
            String name = br.readLine();
            if (set.contains(name)) {
                list.add(name);
            }
        }
        list.sort(null);

        System.out.println(list.size());
        for (String n : list) {
            System.out.println(n);
        }
    }

}
