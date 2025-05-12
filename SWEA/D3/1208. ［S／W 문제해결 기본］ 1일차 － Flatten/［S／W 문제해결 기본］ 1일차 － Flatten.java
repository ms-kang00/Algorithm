import java.io.*;
import java.util.*;

public class Solution
{
    static int[] boxes;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int dump = Integer.parseInt(br.readLine());

            boxes = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                boxes[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < dump; i++) {
                int maxIndex = 0;
                int minIndex = 0;

                for (int j = 0; j < 100; j++) {
                    if (boxes[j] > boxes[maxIndex]) maxIndex = j;
                    else if (boxes[j] < boxes[minIndex]) minIndex = j;
                }

                if (boxes[maxIndex] - boxes[minIndex] <= 1) break;

                boxes[maxIndex]--;
                boxes[minIndex]++;
            }

            int max = boxes[0];
            int min = boxes[0];

            for (int i = 0; i < 100; i++) {
                max = Math.max(max, boxes[i]);
                min = Math.min(min, boxes[i]);
            }

            bw.write("#" + test_case + " " + (max - min) + "\n");
        }
        bw.flush();
        bw.close();
    }

}