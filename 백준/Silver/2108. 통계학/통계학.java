import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> list;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //산술평균
        double sumAvg = 0;
        //중앙값
        int medium = 0;
        //범위
        int coverage = 0;

        list = new ArrayList<>();
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        sumAvg = (double) sum / list.size();
        System.out.println(Math.round(sumAvg));
        list.sort(null);
        
        medium = list.get(n/2);
        System.out.println(medium);

        map = new HashMap<>();
        for (int num : list) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int findMax = 0;
        List<Integer> freq = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value > findMax) {
                findMax = value;
                freq.clear();
                freq.add(key);
            } else if (value == findMax) {
                freq.add(key);
            }

        }

        freq.sort(null);
        if (freq.size() > 1) {
            System.out.println(freq.get(1));
        } else {
            System.out.println(freq.get(0));
        }

        coverage = list.get(list.size()-1) - list.get(0);
        System.out.println(coverage);
    }


}
