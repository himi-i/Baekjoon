import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
maze = [list(map(int, input().strip())) for _ in range(N)]

dist = [[0] * M for _ in range(N)]

q = deque()
q.append((0, 0))
dist[0][0] = 1

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

while q:
    x, y = q.popleft()
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if 0 <= nx < N and 0 <= ny < M:
            if maze[nx][ny] == 1 and dist[nx][ny] == 0:
                dist[nx][ny] = dist[x][y] + 1
                q.append((nx, ny))

print(dist[N-1][M-1])
