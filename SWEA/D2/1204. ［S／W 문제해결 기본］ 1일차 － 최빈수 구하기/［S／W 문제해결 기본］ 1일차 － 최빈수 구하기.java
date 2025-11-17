import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int TC = Integer.parseInt(br.readLine());

            int[] count = new int[101]; // 매 테스트마다 초기화
            int max = 0;
            int result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            // 1000개의 점수 입력
            for (int j = 0; j < 1000; j++) {
                int score = Integer.parseInt(st.nextToken());
                count[score]++;
            }

            // 최빈수 찾기 (동점이면 큰 점수 선택)
            for (int i = 0; i <= 100; i++) {
                if (count[i] > max || (count[i] == max && i > result)) {
                    max = count[i];
                    result = i;
                }
            }

            System.out.println("#" + TC + " " + result);
        }
    }
}
