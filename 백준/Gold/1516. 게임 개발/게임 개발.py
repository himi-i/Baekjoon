from collections import deque
import sys
input = sys.stdin.readline

N = int(input())

time = [0] * (N + 1)
graph = [[] for _ in range(N + 1)]
indegree = [0] * (N + 1)

for i in range(1, N + 1):
    data = list(map(int, input().split()))
    time[i] = data[0]
    for x in data[1:-1]:
        graph[x].append(i)
        indegree[i] += 1

dp = [0] * (N + 1)

q = deque()

for i in range(1, N + 1):
    if indegree[i] == 0:
        q.append(i)
        dp[i] = time[i]

while q:
    now = q.popleft()

    for nxt in graph[now]:
        indegree[nxt] -= 1
        dp[nxt] = max(dp[nxt], dp[now] + time[nxt])

        if indegree[nxt] == 0:
            q.append(nxt)

for i in range(1, N + 1):
    print(dp[i])
