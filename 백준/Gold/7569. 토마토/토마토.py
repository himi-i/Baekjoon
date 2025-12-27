import sys
from collections import deque

input = sys.stdin.readline

dz = [1, -1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dx = [0, 0, 0, 0, 1, -1]

def main():

    M, N, H = map(int, input().split())

    box = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]

    q = deque()

    for z in range(H):
        for y in range(N):
            for x in range(M):
                if box[z][y][x] == 1:
                    q.append((z, y, x))

    while q:
        z, y, x = q.popleft()

        for i in range(6):
            nz = z + dz[i]
            ny = y + dy[i]
            nx = x + dx[i]

            if not (0 <= nz < H and 0 <= ny < N and 0 <= nx < M):
                continue

            if box[nz][ny][nx] == 0:
                box[nz][ny][nx] = box[z][y][x] + 1
                q.append((nz, ny, nx))

    day = 0
    for z in range(H):
        for y in range(N):
            for x in range(M):
                if box[z][y][x] == 0:
                    print(-1)
                    return
                day = max(day, box[z][y][x])

    print(day - 1)

if __name__ == "__main__":
    main()
