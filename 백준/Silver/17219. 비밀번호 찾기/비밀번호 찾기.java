import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] input = line.split(" ");
            map.put(input[0], input[1]);
        }

        for (int i = 0; i < m; i++) {
            String key = br.readLine();
            if (map.containsKey(key)) {
                bw.write(map.get(key) + "\n");
            }
        }
        
        
        bw.flush();
    }
}
