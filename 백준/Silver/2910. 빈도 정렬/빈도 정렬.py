from heapq import heappop, heappush
import sys
input = sys.stdin.readline
 
n, c = map(int, input().split())
arr = list(map(int, input().split()))
 
dict = {}
for i in range(n):
    if arr[i] not in dict:
        dict[arr[i]] = [i, 1]
    else:
        dict[arr[i]][1] += 1
 
hq = []
for k, v in dict.items():
    heappush(hq, [-v[1], v[0], k])
 
while hq:
    cnt, idx, num = heappop(hq)
    for _ in range(-cnt):
        print(num, end=" ")