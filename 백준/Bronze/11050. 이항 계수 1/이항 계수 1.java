
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        bw.write(binomial(n, k) + "\n");
        bw.flush();
    }

    private static int binomial(int n, int k) {
        if (k > n - k) {
            k = n - k;
        }

        int result = 1;

        for (int i=0; i<k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }
}
