import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(map(int, input().strip())) for _ in range(n)]

dx = [1,-1,0,0]
dy = [0,0,1,-1]

q = deque()
q.append((0,0))

while q:
    x,y = q.popleft()

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0<=nx<n and 0<=ny<m and board[nx][ny] == 1:
            board[nx][ny] = board[x][y] + 1
            q.append((nx,ny))

print(board[n-1][m-1])