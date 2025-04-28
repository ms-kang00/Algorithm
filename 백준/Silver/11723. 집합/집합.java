import java.io.*;
import java.util.*;

public class Main {
    static int m;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        m = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            
            if (key.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                set.add(x);
            } else if (key.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                set.remove(x);
            } else if (key.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                if (set.contains(x)) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (key.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if (set.contains(x)) {
                    set.remove(x);
                } else {
                    set.add(x);
                }
            } else if (key.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
            } else if (key.equals("empty")) {
                set.clear();
            }
        }

        
        bw.flush();
        bw.close();
    
    }

}
