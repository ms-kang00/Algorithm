import java.io.*;
import java.util.*;

public class Solution
{
    static Map<String, Integer> map = new HashMap<>();
    static {
        map.put("0001101", 0);
        map.put("0011001", 1);
        map.put("0010011", 2);
        map.put("0111101", 3);
        map.put("0100011", 4);
        map.put("0110001", 5);
        map.put("0101111", 6);
        map.put("0111011", 7);
        map.put("0110111", 8);
        map.put("0001011", 9);
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            String codeLine = "";
            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                if (line.contains("1")) {
                    codeLine = line;
                }
            }

            int endIndex = codeLine.lastIndexOf("1");
            String binaryCode = codeLine.substring(endIndex - 55, endIndex + 1);

            List<Integer> code = new ArrayList<>();
            for (int i = 0; i < 56; i += 7) {
                String pattern = binaryCode.substring(i, i + 7);
                if (!map.containsKey(pattern)) {
                    code.clear();
                    break;
                }
                code.add(map.get(pattern));
            }
            int result = 0;

            if (code.size() == 8) {
                int oddSum = 0, evenSum = 0;
                for (int i = 0; i < 8; i++) {
                    if (i % 2 == 0) {
                        oddSum += code.get(i);
                    } else {
                        evenSum += code.get(i);
                    }
                }
                if ((oddSum * 3 + evenSum) % 10 == 0) {
                    for (int num : code) {
                        result += num;
                    }
                }

            }
            bw.write("#" + test_case + " " + result + "\n");
        }
        bw.flush();
        bw.close();
    }

}