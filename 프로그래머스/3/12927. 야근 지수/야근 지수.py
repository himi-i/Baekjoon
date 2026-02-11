import heapq

def solution(n, works):
    
    if sum(works) <= n:
        return 0
    
    q = []
    for work in works:
        heapq.heappush(q, -work)
    
    for _ in range(n):
        x = -heapq.heappop(q)
        x -= 1
        heapq.heappush(q, -x)
        
    answer = 0
    for work in q:
        answer += (-work) ** 2
        
    return answer