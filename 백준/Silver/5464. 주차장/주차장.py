import sys
import heapq #우선순위 큐
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

#요금
fee = [0] * (N + 1)
for i in range(1, N + 1):
    fee[i] = int(input())

#무게
weight = [0] * (M + 1)
for i in range(1, M + 1):
    weight[i] = int(input())

available = list(range(1, N + 1))
heapq.heapify(available) # 리스트를 최소 힙으로 변환

# 대기 차량 큐
waiting = deque()

parked = {}

total_cost = 0

for _ in range(2 * M):
    x = int(input()) # 차량 번호

    
    if x > 0:
        if available: 
            spot = heapq.heappop(available)
            parked[x] = spot
        else:  
            waiting.append(x)

    else:
        car = -x
        spot = parked.pop(car)

       
        total_cost += weight[car] * fee[spot]

        if waiting:
            next_car = waiting.popleft()
            parked[next_car] = spot
        else:
            heapq.heappush(available, spot)

print(total_cost)
