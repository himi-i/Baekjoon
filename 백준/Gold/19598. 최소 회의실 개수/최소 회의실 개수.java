import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 끝 시간
        }

        // 시작 시간 기준으로 오름차순 정렬, 
        // 시작 시간이 같으면 끝 시간으로
        Arrays.sort(meetings, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            // 가장 빨리 끝나는 회의보다 지금 회의 시작이 늦으면 같은 회의실 사용 가능
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            pq.add(end);
        }

        System.out.println(pq.size());
    }
}
