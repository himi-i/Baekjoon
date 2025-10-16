import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0}; // 하, 상, 우, 좌
    static int[] dy = {0, 0, 1, -1};
    static boolean cycle = false; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, -1, -1, board[i][j]);
                    if (cycle) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }

        System.out.println("No");
    }

    static void dfs(int x, int y, int px, int py, char color) {
        visited[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] == color) {
                if (!visited[nx][ny]) {
                    dfs(nx, ny, x, y, color);
                } else if (!(nx == px && ny == py)) {
                    cycle = true;
                    return;
                }
            }
        }
    }
}
