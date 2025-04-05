import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int A, B;
    static boolean[] visited;
    static class DSLR {
        int num;
        String line;

        public DSLR(int num, String line) {
            this.num = num;
            this.line = line;
        }

        public int D() {
            return (2 * num) % 10000;
        }

        public int S() {
            return (num == 0) ? 9999 : num - 1;
        }

        public int L() {
            return (num % 1000) * 10 + (num / 1000);
        }

        public int R() {
            return (num % 10) * 1000 + (num / 10);
        }
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            visited = new boolean[10000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            BFS(bw);
        }
        br.close();
        bw.flush();
        bw.close();
    }
    
    private static void BFS(BufferedWriter bw) throws IOException{
        
        Queue<DSLR> q = new LinkedList<>();
        visited[A] = true;
        q.offer(new DSLR(A, ""));
        
        while (!q.isEmpty()) {
            DSLR dslr = q.poll();

            if (dslr.num == B) {
                bw.write(dslr.line + "\n");
                return;
            }

            if (!visited[dslr.D()]) {
                visited[dslr.D()] = true;
                q.offer(new DSLR(dslr.D(), dslr.line + "D"));
            }

            if (!visited[dslr.S()]) {
                visited[dslr.S()] = true;
                q.offer(new DSLR(dslr.S(), dslr.line + "S"));
            }

            if (!visited[dslr.L()]) {
                visited[dslr.L()] = true;
                q.offer(new DSLR(dslr.L(), dslr.line + "L"));
            }

            if (!visited[dslr.R()]) {
                visited[dslr.R()] = true;
                q.offer(new DSLR(dslr.R(), dslr.line + "R"));
            }
        }
    }
}
