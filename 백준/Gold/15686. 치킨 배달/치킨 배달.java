import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N, M;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                //좌표값을 각각 저장
                if (value == 1) houses.add(new int[]{i, j});
                else if (value == 2) chickens.add(new int[]{i, j});
            }
        }

        dfs(0, 0, new int[M]);
        System.out.println(minDistance);
    }

    static void dfs(int idx, int depth, int[] result) {
        if (depth == M) {
            int sum = 0;
            for (int[] house : houses) {
                int minDist = Integer.MAX_VALUE;
                for (int i = 0; i < M; i++) {
                    int[] chicken = chickens.get(result[i]);
                    int dist = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                    minDist = Math.min(minDist, dist); // 집 하나 당 치킨거리 구하기
                }
                sum += minDist; // 해당 조합에서 최소 도시의 치킨 거리
            }
            minDistance = Math.min(minDistance, sum); //모든 조합에서 최소
            return;
        }

        // 모든 조합을 만드는 반복문
        for (int i = idx; i < chickens.size(); i++) {
            result[depth] = i;
            dfs(i + 1, depth + 1, result);
        }
    }

    /*
dfs(0,0,[])  i = 0 선택
dfs(1, 1, [0, _])
dfs(2, 2, [0,1])
dfs(3, 2, [0,2])
dfs(4, 2, [0,3])
dfs(1, 1, [0,_]) 루프 종료
dfs(0,0,[]) 다시 들어옴
dfs(2, 1, [1,_]) 다시 시작 i = 1 선택
     */
}
