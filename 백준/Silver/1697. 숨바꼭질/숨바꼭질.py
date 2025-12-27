import sys
from collections import deque

input = sys.stdin.readline

def main():
    N, K = map(int, input().split())

    if N >= K:
        print(N - K)
        sys.exit()

    MAX = 100000
    visited = [-1] * (MAX + 1)
    visited[N] = 0
    q = deque([N])   

    while q:
        x = q.popleft()
        if x == K:
            break

        for nx in (x - 1, x + 1, x * 2):
            if 0 <= nx <= MAX and visited[nx] == -1:
                visited[nx] = visited[x] + 1
                q.append(nx)

    print(visited[K])

if __name__ == "__main__":
    main()
