import sys
from collections import deque

input = sys.stdin.readline
#레벨중에서 맥스 -> 그중에서 맥스값을 구하는 것 -> 따라서 bfs

def main():
    N = int(input())
    graph = [list(map(int, input().split())) for _ in range(N)]
    max_h = max(map(max, graph)) #각 행에서 최댓값 -> 그중에서 최댓값
    # 물 높이 h를 0 ~ max_h 까지 올려가며 탐색
    result = 1 #적어도 1이기 때문에

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    for h in range(max_h + 1):
        visited = [[False] * N for _ in range(N)]
        ans = 0 # 안전 구역 개수

        for a in range(N):
            for b in range(N):
                if graph[a][b] > h and not visited[a][b]:
                    ans += 1
                    q = deque([(a, b)])
                    visited[a][b] = True

                    while q:
                        x, y = q.popleft()
                        for i in range(4):
                            nx = x + dx[i]
                            ny = y + dy[i]

                            if 0 <= nx < N and 0 <= ny < N:
                                if graph[nx][ny] > h and not visited[nx][ny]:
                                    visited[nx][ny] = True
                                    q.append((nx, ny))

        result = max(result, ans) 
    print(result)

if __name__ == "__main__":
    main()


