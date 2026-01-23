import sys
from collections import deque

input = sys.stdin.readline

N, M, K, X = map(int, input().split())

graph = [[] for _ in range(N + 1)]
for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)

distance = [-1] * (N + 1)
distance[X] = 0

q = deque([X])

while q:
    cur = q.popleft()
    for nxt in graph[cur]:
        if distance[nxt] == -1:
            distance[nxt] = distance[cur] + 1
            q.append(nxt)

answer = []
for i in range(1, N + 1):
    if distance[i] == K:
        answer.append(i)

if answer:
    print('\n'.join(map(str, answer)))
else:
    print(-1)
