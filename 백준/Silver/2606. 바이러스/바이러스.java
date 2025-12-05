import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count = 0; // 1번과 연결된 컴퓨터 수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int M = Integer.parseInt(br.readLine()); // 연결 수

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        // 인접 리스트 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 연결 정보 입력
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 무방향 그래프이므로 양쪽에 연결
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1); // 1번 컴퓨터부터 감염 시작

        System.out.println(count);
    }

    static void dfs(int x) {
        visited[x] = true;

        for (int next : graph[x]) {
            if (!visited[next]) {
                count++; // 1번 제외 감염된 컴퓨터 수 증가
                dfs(next);
            }
        }
    }
}
