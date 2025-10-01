import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] move = new int[101];
        for (int i = 1; i <= 100; i++) move[i] = i;

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            move[from] = to;
        }

        int[] dist = new int[101];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        dist[1] = 0;
        q.add(1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == 100) break;

            for (int d = 1; d <= 6; d++) {
                int nx = cur + d;
                if (nx > 100) continue;
                nx = move[nx]; // 사다리/뱀 이동
                if (dist[nx] == -1) {
                    dist[nx] = dist[cur] + 1;
                    q.add(nx);
                }
            }
        }

        System.out.println(dist[100]);
    }
}