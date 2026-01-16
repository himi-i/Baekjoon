import sys
input = sys.stdin.readline

from collections import deque

N, K = map(int, input().split())
name_len = [0] * 21
window = deque() #슬라이딩 윈도우
count = 0

for _ in range(N):
    x = len(input().strip())
    window.append(x)
    name_len[x] += 1

    if len(window) > K+1:
        out = window.popleft()
        name_len[out] -= 1
    
    count += name_len[x] - 1

print(count)