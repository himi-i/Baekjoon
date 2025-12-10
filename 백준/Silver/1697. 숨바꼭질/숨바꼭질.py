from collections import deque

n, k = map(int, input().split())
MAX = 100000
visited = [-1] * (MAX + 1)

q = deque([n])
visited[n] = 0
while q:
    x = q.popleft()

    if x == k:
        break
    for nx in (x - 1, x + 1, x * 2):
        if(0 <= nx <= MAX and visited[nx] == -1):
            visited[nx] = visited[x] + 1
            q.append(nx)

print(visited[k])