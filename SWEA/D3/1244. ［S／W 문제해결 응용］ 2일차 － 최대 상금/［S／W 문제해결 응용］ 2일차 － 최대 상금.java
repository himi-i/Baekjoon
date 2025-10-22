import java.io.*;
import java.util.*;

public class Solution {
    static int max;
    static int changeCount;
    static char[] numbers;
    static Set<String> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            numbers = st.nextToken().toCharArray();
            changeCount = Integer.parseInt(st.nextToken());
            max = 0;
            visited = new HashSet<>();

            dfs(0);

            System.out.println("#" + testCase + " " + max);
        }
    }

    static void dfs(int depth) {
        if (depth == changeCount) {
            max = Math.max(max, Integer.parseInt(String.valueOf(numbers)));
            return;
        }

        String state = new String(numbers) + "_" + depth;
        if (visited.contains(state)) return;
        visited.add(state);

        int len = numbers.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                swap(i, j);
                dfs(depth + 1);
                swap(i, j); // 원상 복구
            }
        }
    }

    static void swap(int i, int j) {
        char temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
