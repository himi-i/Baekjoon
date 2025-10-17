import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N, M;
    static int[][] city;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1) houses.add(new int[]{i, j});
                else if (city[i][j] == 2) chickens.add(new int[]{i, j});
            }
        }

        dfs(0, 0, new int[M]);
        System.out.println(minDistance);
    }

    static void dfs(int idx, int depth, int[] selected) {
        if (depth == M) {
            int sum = 0;
            for (int[] house : houses) {
                int minDist = Integer.MAX_VALUE;
                for (int i = 0; i < M; i++) {
                    int[] chicken = chickens.get(selected[i]);
                    int dist = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                    minDist = Math.min(minDist, dist);
                }
                sum += minDist;
            }
            minDistance = Math.min(minDistance, sum); //최소 거리 계산 
            return;
        }

        for (int i = idx; i < chickens.size(); i++) {
            selected[depth] = i;
            dfs(i + 1, depth + 1, selected);
        }
    }
}
