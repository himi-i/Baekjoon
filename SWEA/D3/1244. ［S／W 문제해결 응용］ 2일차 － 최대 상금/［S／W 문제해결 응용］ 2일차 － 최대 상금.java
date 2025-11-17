import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {

    static String num;
    static int change;
    static int answer;
    static HashSet<String>[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String[] input = br.readLine().split(" ");
            num = input[0];
            change = Integer.parseInt(input[1]);

            visited = new HashSet[change + 1];
            for (int i = 0; i <= change; i++) {
                visited[i] = new HashSet<>();
            }

            answer = 0;
            dfs(num, 0);

            System.out.println("#" + tc + " " + answer);
        }
    }

   
    static void dfs(String now, int cnt) {
       
        if (cnt == change) {
            answer = Math.max(answer, Integer.parseInt(now));
            return;
        }

       
        if (visited[cnt].contains(now)) return;
        visited[cnt].add(now);

       
        char[] arr = now.toCharArray();
        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {

                swap(arr, i, j);
                dfs(new String(arr), cnt + 1);
                swap(arr, i, j); 
            }
        }
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
