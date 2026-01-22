import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

q = deque()
for _ in range(N):
    name, num = input().split()
    num = int(num)
    q.append((name, num))


while len(q) > 1:
    name, x = q.popleft()
   
    q.rotate(-(x - 1))
  
    q.popleft()

print(q[0][0])
