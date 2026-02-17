import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, list(input().strip()))) for _ in range(N)]

dy = [1, -1, 0, 0]
dx = [0, 0, 1, -1]

result = 0

for h in range(1, 10):  
    visited = [[False] * M for _ in range(N)]

    for i in range(N):
        for j in range(M):
            if board[i][j] < h and not visited[i][j]:
                queue = deque()
                queue.append((i, j))
                visited[i][j] = True

                cells = [(i, j)]
                is_edge = False

                while queue:
                    y, x = queue.popleft()

                    
                    if y == 0 or y == N-1 or x == 0 or x == M-1:
                        is_edge = True

                    for d in range(4):
                        ny = y + dy[d]
                        nx = x + dx[d]

                        if 0 <= ny < N and 0 <= nx < M:
                            if board[ny][nx] < h and not visited[ny][nx]:
                                visited[ny][nx] = True
                                queue.append((ny, nx))
                                cells.append((ny, nx))

               
                if not is_edge:
                    result += len(cells)

print(result)
