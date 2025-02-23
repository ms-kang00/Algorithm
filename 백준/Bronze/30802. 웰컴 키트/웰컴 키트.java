import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] sizes = new int[6];
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int totalShirts = 0;
        for (int count : sizes) {
            totalShirts += (count + T - 1) / T;
        }

        System.out.println(sb.append(totalShirts).append("\n").append(N/P).append(" ").append(N%P));
    }
}