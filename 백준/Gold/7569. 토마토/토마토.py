from collections import deque
import sys

input = sys.stdin.readline

# M: 가로, N: 세로, H: 높이
M, N, H = map(int, input().split())


box = [ [list(map(int, input().split())) for _ in range(N)] for _ in range(H) ]

#box = [
#    [   # 0층
#        [1, 0, -1, 0, 0],
#        [0, 0, 0, 0, 0],
#        [0, -1, 0, 1, 0]
#    ],
#    [   # 1층
#        [0, 0, 0, 0, 0],
#        [-1, -1, 0, 0, 0],
#        [1, 0, 0, 0, -1]
#    ]
#]

q = deque()

# 이미 익은 토마토(1)는 BFS 시작점
for h in range(H):
    for n in range(N):
        for m in range(M):
            if box[h][n][m] == 1:
                q.append((h, n, m))

dh = [1, -1, 0, 0, 0, 0]
dn = [0, 0, 1, -1, 0, 0]
dm = [0, 0, 0, 0, 1, -1]

while q:
    h, n, m = q.popleft()
    for i in range(6):
        nh = h + dh[i]
        nn = n + dn[i]
        nm = m + dm[i]

        # 범위 벗어나면 패스
        if not (0 <= nh < H and 0 <= nn < N and 0 <= nm < M):
            continue

        
        if box[nh][nn][nm] == 0:
            box[nh][nn][nm] = box[h][n][m] + 1  # 하루 증가
            q.append((nh, nn, nm))


days = 0
for h in range(H):
    for n in range(N):
        for m in range(M):
            if box[h][n][m] == 0:    # 못 익은 토마토 발견
                print(-1)
                sys.exit(0)
            days = max(days, box[h][n][m])

# 처음 날짜(1)부터 시작했으므로 -1 해줌
print(days - 1)
