from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

# 지역의 최대 높이
max_h = max(max(row) for row in graph)

# 상하좌우 이동
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(sx, sy, h, visited):
    q = deque()
    q.append((sx, sy))
    visited[sx][sy] = True

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 범위 안, 방문 X, 잠기지 않은 곳
            if 0 <= nx < n and 0 <= ny < n:
                if not visited[nx][ny] and graph[nx][ny] > h:
                    visited[nx][ny] = True
                    q.append((nx, ny))

max_safe = 0

# 비가 오지 않을 수도 있으므로 0부터 시작
for h in range(0, max_h + 1):
    visited = [[False] * n for _ in range(n)]
    safe_count = 0

    for i in range(n):
        for j in range(n):
            # 잠기지 않은 지역(높이 > h)에서 BFS 시작
            if graph[i][j] > h and not visited[i][j]:
                bfs(i, j, h, visited)
                safe_count += 1

    max_safe = max(max_safe, safe_count)

print(max_safe)
