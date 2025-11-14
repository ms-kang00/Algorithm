import java.util.*;
import java.io.*;

public class Solution {
    static int[] charge, weight;
    static Queue<Integer> queue;

    static int[] parked, carLocation;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            queue = new ArrayDeque<>();
            charge = new int[n + 1];
            weight = new int[m + 1];
            for (int i = 1; i <= n; i++) {
                charge[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 1; i <= m; i++) {
                weight[i] = Integer.parseInt(br.readLine());
            }

            int result = 0;
            parked = new int[n + 1];
            carLocation = new int[m + 1];
            for (int i = 0; i < 2 * m; i++) {
                int carNum = Integer.parseInt(br.readLine());

                if (carNum > 0) {
                    int emptySpot = -1;
                    for (int spot = 1; spot <= n; spot++) {
                        if (parked[spot] == 0) {
                            emptySpot = spot;
                            break;
                        }
                    }

                    if (emptySpot != -1) {
                        parked[emptySpot] = carNum;
                        carLocation[carNum] = emptySpot;
                        result += charge[emptySpot] * weight[carNum];
                    } else {
                        queue.offer(carNum);
                    }
                } else {
                    int spot = carLocation[Math.abs(carNum)];

                    parked[spot] = 0;
                    carLocation[Math.abs(carNum)] = 0;

                    if (!queue.isEmpty()) {
                        int waitingCarNum = queue.poll();

                        parked[spot] = waitingCarNum;
                        carLocation[waitingCarNum] = spot;
                        result += charge[spot] * weight[waitingCarNum];
                    }
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }

}