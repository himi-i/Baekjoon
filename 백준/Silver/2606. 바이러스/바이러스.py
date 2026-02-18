import sys
input = sys.stdin.readline

num = int(input())
X = int(input())

graph = [[] for _ in range(num + 1)]
visited = [False] * (num + 1)

for _ in range(X):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

count = 0

def dfs(number):
    global count

    visited[number] = True
    for x in graph[number]:
        if not visited[x]:
            count += 1
            dfs(x)

dfs(1)
print(count)