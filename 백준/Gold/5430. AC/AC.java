import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static Deque<Integer> q;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            q = new ArrayDeque<>();

            input = input.substring(1, input.length()-1);
            if (!input.isEmpty()) {
                String[] element = input.split(",");

                for (String str : element) {
                    q.offer(Integer.parseInt(str));
                }
            }
            boolean reverse = false;
            boolean empty = false;

        
            for (int j = 0; j < s.length(); j++) {
                
                if (s.charAt(j) == 'R') {
                    reverse = !reverse;
                } else if (s.charAt(j) == 'D') {
                    if (q.isEmpty()) {
                        empty = true;
                        break;
                    }
                    if (reverse) {
                        q.removeLast();
                    } else {
                        q.removeFirst();
                    }
                }
            }
    
            if (empty) {
                bw.write("error\n");
            } else {
                bw.write("[");
                while (!q.isEmpty()) {
                    if (reverse) {
                        bw.write(q.removeLast().toString());
                    } else {
                        bw.write(q.removeFirst().toString());
                    }
                    if (!q.isEmpty()) {
                        bw.write(",");
                    }
                }
                bw.write("]\n");
            }
        
        }

        
        
        bw.flush();
        bw.close();
    
    }

}
