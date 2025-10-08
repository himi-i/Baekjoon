import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, K, L;
    static int[][] map;
    static Map<Integer, Character> turns = new HashMap<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            turns.put(t, c);
        }

        System.out.println(simulate());
    }

    static int simulate() {
        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0, 0});
        map[0][0] = 2;

        int time = 0;
        int dir = 0;

        while (true) {
            time++;
            int[] head = snake.peekFirst();
            int nx = head[0] + dx[dir];
            int ny = head[1] + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 2)
                return time;

            if (map[nx][ny] == 1) {
                map[nx][ny] = 2;
                snake.addFirst(new int[]{nx, ny});
            } else {
                map[nx][ny] = 2;
                snake.addFirst(new int[]{nx, ny});
                int[] tail = snake.removeLast();
                map[tail[0]][tail[1]] = 0;
            }

            if (turns.containsKey(time)) {
                char turn = turns.get(time);
                if (turn == 'D') dir = (dir + 1) % 4;
                else dir = (dir + 3) % 4;
            }
        }
    }
}
