import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static Deque<String> q;
    static class Status {
        boolean reverse, empty;

        public Status(boolean reverse, boolean empty) {
            this.reverse = reverse;
            this.empty = empty;
        }
    }

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
                    q.offer(str);
                }
            }

            Status status = checkRD(s);
            printResult(bw, status.reverse, status.empty);
            
        
        }

        bw.flush();
        bw.close();
    
    }

    static Status checkRD(String str) {
        boolean reverse = false;
        boolean empty = false;
        for (int j = 0; j < str.length(); j++) {
                
            if (str.charAt(j) == 'R') {
                reverse = !reverse;
            } else if (str.charAt(j) == 'D') {
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
        return new Status(reverse, empty);
    }

    static void printResult(BufferedWriter bw, boolean reverse, boolean empty) throws Exception{
        if (empty) {
            bw.write("error\n");
        } else {
            bw.write("[");
            while (!q.isEmpty()) {
                if (reverse) {
                    bw.write(q.removeLast());
                } else {
                    bw.write(q.removeFirst());
                }
                if (!q.isEmpty()) {
                    bw.write(",");
                }
            }
            bw.write("]\n");
        }
    }

}
