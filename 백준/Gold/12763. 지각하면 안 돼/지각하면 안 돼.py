import sys
import heapq
input = sys.stdin.readline

N = int(input())
T, M = map(int, input().split())
L = int(input())

graph = [[] for _ in range(N + 1)]
for _ in range(L):
    a, b, t, c = map(int, input().split())
    graph[a].append((b, t, c))
    graph[b].append((a, t, c))  

INF = 10**15
dp = [[INF] * (T + 1) for _ in range(N + 1)]
dp[1][0] = 0

pq = [(0, 1, 0)]  # (비용, 현재건물, 사용시간)

while pq:
    cost, now, time = heapq.heappop(pq)

    if dp[now][time] < cost:
        continue

    for nxt, t, c in graph[now]:
        nt = time + t
        nc = cost + c

        if nt > T or nc > M:
            continue

        if dp[nxt][nt] > nc:
            dp[nxt][nt] = nc
            heapq.heappush(pq, (nc, nxt, nt))

answer = min(dp[N])
print(answer if answer != INF else -1)
