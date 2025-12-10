from collections import deque

F, S, G, U, D = map(int, input().split())
visited = [-1] * (F + 1)

q = deque([S])
visited[S] = 0 
while q:
    x = q.popleft()

    if x == G:
        break
    for nx in(x + U, x - D):
        if 1 <= nx <= F and visited[nx] == -1:
            visited[nx] = visited[x] + 1
            q.append(nx)

if visited[G] == -1:
    print("use the stairs")
else:
    print(visited[G])


