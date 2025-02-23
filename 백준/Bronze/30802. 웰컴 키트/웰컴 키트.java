import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sizes = new int[6];
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st2.nextToken());
        int P = Integer.parseInt(st2.nextToken());

        int totalShirts = 0;
        for (int count : sizes) {
            totalShirts += (count + T - 1) / T;
        }

        int penBundle = N / P;
        int remain = N % P;

        System.out.println(totalShirts);
        System.out.print(penBundle + " " + remain);
    }
}