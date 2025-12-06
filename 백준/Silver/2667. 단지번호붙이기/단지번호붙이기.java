import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Main{

    static ArrayList<Integer> result = new ArrayList<>();
    static boolean[][] visited;
    static int[][] map;
    static int count;

    static int N;

    static int[] dx = {-1, 0 , 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); 
        

        visited = new boolean[N][N];
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && !visited[i][j]) {
                
                    count = 0;                
                    dfs(i, j);
                    result.add(count);
                }
            }
        }
        
        Collections.sort(result); //오름차순

        System.out.println(result.size());
        for(int cnt : result){
            System.out.println(cnt);
        }

    }

    static void dfs(int cx, int cy){
        count++;
        visited[cx][cy] = true;

        for(int i = 0; i < 4; i++){
            int nx = dx[i] + cx;
            int ny = dy[i] + cy;

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(map[nx][ny] == 0) continue;
            if(visited[nx][ny]) continue;

            dfs(nx, ny);
        }
        

    }
}