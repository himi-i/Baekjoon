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
    
    // 동, 남, 서, 북
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        
        // 사과 위치 표시
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x][y] = 1; // 사과는 1로 표시
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
        map[0][0] = 2; // 뱀 위치 표시
        
        int time = 0;
        int dir = 0; // 처음에는 동쪽
        while (true) {
            time++;
            int[] head = snake.peekLast();
            int nx = head[0] + dx[dir];
            int ny = head[1] + dy[dir];
            
            // 벽이나 자기 몸과 충돌
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 2) {
                return time;
            }
            
            // 이동
            if (map[nx][ny] == 1) { // 사과
                map[nx][ny] = 2;
                snake.addLast(new int[]{nx, ny});
            } else { // 빈칸
                map[nx][ny] = 2;
                snake.addLast(new int[]{nx, ny});
                int[] tail = snake.pollFirst();
                map[tail[0]][tail[1]] = 0;
            }
            
            // 방향 회전
            if (turns.containsKey(time)) {
                char c = turns.get(time);
                if (c == 'L') {
                    dir = (dir + 3) % 4; // 왼쪽
                } else {
                    dir = (dir + 1) % 4; // 오른쪽
                }
            }
        }
    }
}
