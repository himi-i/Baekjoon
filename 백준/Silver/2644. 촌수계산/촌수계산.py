# 2644 촌수 - Python (BFS)
import sys
from collections import deque

input = sys.stdin.readline # standard input

def main():
    n = int(input().strip()) #개행 문자 제거
    a, b = map(int, input().split()) 

    #문자열을 받고 빈칸으로 분리 -> int로 변환
    #map(변환함수, 반복가능한자료)

    m = int(input().strip())

    # 인접리스트 (1..n 사용)
    graph = [[] for _ in range(n + 1)] 

    # []를 n + 1 만큼 만들기
    #[ [], [], [], [], ... ] 이렇게 생긴 2차원 리스트 생성

    for _ in range(m):
        x, y = map(int, input().split())
        graph[x].append(y)
        graph[y].append(x)

    dist = [-1] * (n + 1)
    q = deque([a])
    dist[a] = 0

    while q: 
        cur = q.popleft()  # 큐니까 앞에서 빼고 뒤에서 넣고
        if cur == b:
            break
        for nx in graph[cur]:
            if dist[nx] == -1:
                dist[nx] = dist[cur] + 1
                q.append(nx)  #[1, 2, 3] → append(5) → [1, 2, 3, 5]

    print(dist[b])

if __name__ == "__main__":
    main()
