import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] trees;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        trees = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int result = binarySearch();
        bw.write(result + "\n");
        

        bw.flush();
        bw.close();
    }

    static int binarySearch() {
        int low = 0;
        int high = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (trees[i] > high) {
                high = trees[i];
            }
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            long wood = getWood(mid);

            if (wood >= m) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

    static long getWood(int height) {
        long sum = 0;
        for (int tree : trees) {
            if (tree > height) {
                sum += tree - height;
            }
        }
        return sum;
    }

}
