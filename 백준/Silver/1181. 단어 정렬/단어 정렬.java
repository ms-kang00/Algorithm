import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> sameWords = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            sameWords.add(br.readLine());
        }

        List<String> words = new ArrayList<>(sameWords);
        Collections.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return Integer.compare(a.length(), b.length());
            }
            return a.compareTo(b);
        });

        for (String word : words) {
            System.out.println(word);
        }
    }
}