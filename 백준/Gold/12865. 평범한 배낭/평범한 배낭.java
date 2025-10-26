import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 물품 개수
        int k = Integer.parseInt(st.nextToken()); // 배낭 최대 무게

        int[] weight = new int[n + 1]; // 물품 무게
        int[] value = new int[n + 1];  // 물품 가치

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][k + 1];

        // DP 수행
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= k; w++) {
                if (w >= weight[i]) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i]] + value[i]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // 최대 가치 출력
        System.out.println(dp[n][k]);
    }
}
