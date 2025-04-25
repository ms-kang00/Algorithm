import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        String[] arr = new String[n+1];

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            map.put(name, i);   
            arr[i] = name;
        }

        for (int i = 1; i <= m; i++) {
            String query = br.readLine();

            if (Character.isDigit(query.charAt(0))) {
                int num = Integer.parseInt(query);
                bw.write(arr[num] + "\n");
            } else {
                bw.write(map.get(query) + "\n");
            }
        }
        

        bw.flush();
        bw.close();
    }

}
