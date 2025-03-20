import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int num;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int temp = 0;
        for (int i = 0; i < M; i++) {
            int start = 0;
            int end = N - 1;
            num = Integer.parseInt(st.nextToken());


            if (findNum(arr, start, end, temp) == 1) {
                bw.write(1 + "\n");
                temp = 0;
            } else {
                bw.write(0 + "\n");
            }

        }
        
        br.close();
        bw.flush();
        bw.close();
    }

    private static int findNum(int[] arr, int start, int end, int temp) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == num) {
                temp = 1;
                break;
            } else if (num > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return temp;
    }
}
