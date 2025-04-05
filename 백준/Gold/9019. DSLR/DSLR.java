import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static boolean[] visited;
    static String[] lines;
    static Queue<Integer> q = new LinkedList<>();
    static int A, B;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        visited = new boolean[10000];
        lines = new String[10000];
        
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            Arrays.fill(lines, "");
            Arrays.fill(visited, false);
            
            q.clear();
            bfs();
            bw.write(lines[B] + "\n");
        }
        

        bw.flush();
        br.close();
        bw.close();
    }
    
    private static void bfs() {
        q.add(A);
        visited[A] = true;

        while (!q.isEmpty()) {
            int n = q.poll();

            if(n == B){
                break;
            }

            int D = (n * 2) % 10000;
            int S = (n == 0) ? 9999 : n - 1;
            int L = (n % 1000) * 10 + (n / 1000);
            int R = (n % 10) * 1000 + (n / 10);

            if (!visited[D]) {
                q.add(D);
                visited[D] = true;
                lines[D] = lines[n] + "D";
            }

            if (!visited[S]) {
                q.add(S);
                visited[S] = true;
                lines[S] = lines[n] + "S";
            }

            if (!visited[L]) {
                q.add(L);
                visited[L] = true;
                lines[L] = lines[n] + "L";
            }

            if (!visited[R]) {
                q.add(R);
                visited[R] = true;
                lines[R] = lines[n] + "R";
            }
        }
    }
}
