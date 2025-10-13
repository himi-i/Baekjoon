import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken()); 

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(clean(r, c, d));
    }

    static int clean(int x, int y, int dir) {
        int count = 0;

        // 칸을 청소
        while (true) {
            if (!visited[x][y]) {
                visited[x][y] = true;
                count++;
            }

            // 새칸으로 이동했는지
            boolean moved = false;

            for (int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4; // 반시계방향 회전
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                //빈칸이 있는 경우
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0 && !visited[nx][ny]) {
                    x = nx;
                    y = ny;
                    moved = true;
                    break;
                }
            }

            //빈칸이 없는 경우
            if (!moved) {
                int back = (dir + 2) % 4; // 뒤쪽 방향 -> 방향은 유지
                int nx = x + dx[back];
                int ny = y + dy[back];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                } else {
                    break; // 뒤쪽이 벽이면 종료
                }
            }
        }

        return count;
    }
}
