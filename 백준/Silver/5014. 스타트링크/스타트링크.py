import sys
from collections import deque

input = sys.stdin.readline

def main():
    F, S, G, U, D = map(int, input().split())

    q = deque([S])
    visited = [-1] * (F + 1)
    visited[S] = 0
    while q:
        x = q.popleft()
        if x == G:
            break
        for nx in (x + U, x - D):
            if(1 <= nx <= F and visited[nx] == -1):
                visited[nx] = visited[x] + 1
                q.append(nx)

    if visited[G] == -1:
        print("use the stairs")
    else:
        print(visited[G])

if __name__ == "__main__":
    main()
