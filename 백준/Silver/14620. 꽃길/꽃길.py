import sys
input = sys.stdin.readline

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

visited = [[False]*N for _ in range(N)]

dx = [0, 0, 0, -1, 1]
dy = [0, -1, 1, 0, 0]

min_cost = float('inf')

positions = [(i, j) for i in range(1, N-1) for j in range(1, N-1)]


def dfs(start, count, total):
    global min_cost
    
    if count == 3:
        min_cost = min(min_cost, total)
        return
    
    for i in range(start, len(positions)):
        x, y = positions[i]
        
        cost = 0
        temp = []
        can = True
        
        for d in range(5):
            nx = x + dx[d]
            ny = y + dy[d]
            
            if visited[nx][ny]:
                can = False
                break
            
            cost += board[nx][ny]
            temp.append((nx, ny))
        
        if can:
            for nx, ny in temp:
                visited[nx][ny] = True
            
            dfs(i + 1, count + 1, total + cost)
            
            for nx, ny in temp:
                visited[nx][ny] = False


dfs(0, 0, 0)
print(min_cost)
