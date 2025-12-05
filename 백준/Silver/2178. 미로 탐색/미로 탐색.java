import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static int[][] map;
    static boolean[][] visited;
    static int N, M; 
    static int[][] count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        count = new int[N][M]; 

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(count[N-1][M-1]);

    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        count[x][y] = 1;

        while(!q.isEmpty()){

            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
            

            if(nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;

            if(map[nx][ny] == 0) continue;

            if(visited[nx][ny]) continue;

            q.add(new int[]{nx,ny});
            visited[nx][ny] = true;
            count[nx][ny] = count[cx][cy] + 1;

            }
        }

    }
}