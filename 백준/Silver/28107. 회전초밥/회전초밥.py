import sys
import heapq

input = sys.stdin.readline

N, M = map(int, input().split())

order = [[] for _ in range(200001)]
count = [0] * (N + 1)

for customer in range(1, N+1):
    line = list(map(int, input().split()))
    k = line[0]
    for i in line[1:]:
        heapq.heappush(order[i], customer)
    
for x in map(int, input().split()):
    if order[x]:
        customer_num = heapq.heappop(order[x])
        count[customer_num] += 1

print(*count[1:])


