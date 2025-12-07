import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int N, M; 
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        System.out.println(map[N-1][M-1]);   // 최종 거리 출력
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위 체크
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 벽이거나 이미 방문한 칸(map != 1)이면 스킵
                if(map[nx][ny] != 1) continue;

                // 거리 갱신 (현재 거리 + 1)
                map[nx][ny] = map[cx][cy] + 1;

                // 큐에 추가
                q.add(new int[]{nx, ny});
            }
        }
    }
}
