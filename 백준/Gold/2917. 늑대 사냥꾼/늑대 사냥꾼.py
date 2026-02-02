import sys
from collections import deque
import heapq

input = sys.stdin.readline

N, M = map(int, input().split())
grid = [list(input().rstrip()) for _ in range(N)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

tree_dist = [[-1] * M for _ in range(N)]
q = deque()

for i in range(N):
    for j in range(M):
        if grid[i][j] == '+':
            q.append((i, j))
            tree_dist[i][j] = 0
        elif grid[i][j] == 'V':
            sx, sy = i, j
        elif grid[i][j] == 'J':
            ex, ey = i, j

while q:
    x, y = q.popleft()
    for d in range(4):
        nx, ny = x + dx[d], y + dy[d]
        if 0 <= nx < N and 0 <= ny < M:
            if tree_dist[nx][ny] == -1:
                tree_dist[nx][ny] = tree_dist[x][y] + 1
                q.append((nx, ny))


visited = [[-1] * M for _ in range(N)]
pq = []

heapq.heappush(pq, (-tree_dist[sx][sy], sx, sy))
visited[sx][sy] = tree_dist[sx][sy]

while pq:
    safe, x, y = heapq.heappop(pq)
    safe = -safe

    if x == ex and y == ey:
        print(safe)
        break

    for d in range(4):
        nx, ny = x + dx[d], y + dy[d]
        if 0 <= nx < N and 0 <= ny < M:
            next_safe = min(safe, tree_dist[nx][ny])
            if visited[nx][ny] < next_safe:
                visited[nx][ny] = next_safe
                heapq.heappush(pq, (-next_safe, nx, ny))
