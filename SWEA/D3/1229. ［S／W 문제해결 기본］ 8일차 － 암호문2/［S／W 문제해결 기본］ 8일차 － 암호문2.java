import java.io.*;
import java.util.*;

public class Solution {
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int rawLength = Integer.parseInt(br.readLine());
            list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < rawLength; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int commandNum = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < commandNum; i++) {
                String s = st.nextToken();
                int loc = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());

                if (s.equals("I")) {
                    for (int j = 0; j < count; j++) {
                        list.add(loc + j, Integer.parseInt(st.nextToken()));
                    }
                } else if (s.equals("D")) {
                    for (int j = 0; j < count; j++) {
                        list.remove(loc);
                    }
                }
            }
            bw.write("#" + test_case + " ");
            for (int i = 0; i < 10; i++) {
                bw.write(list.get(i) + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}