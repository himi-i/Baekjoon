from collections import deque

def solution(n, results):
    wins = [[] for _ in range(n + 1)]
    loses = [[] for _ in range(n + 1)]

    for a, b in results:
        wins[a].append(b)
        loses[b].append(a)

    def bfs(start, graph):
        visited = [False] * (n + 1)
        q = deque([start])
        visited[start] = True
        count = 0

        while q:
            cur = q.popleft()
            for nxt in graph[cur]:
                if not visited[nxt]:
                    visited[nxt] = True
                    q.append(nxt)
                    count += 1
        return count

    answer = 0
    for i in range(1, n + 1):
        win_count = bfs(i, wins)
        lose_count = bfs(i, loses)

        if win_count + lose_count == n - 1:
            answer += 1

    return answer
