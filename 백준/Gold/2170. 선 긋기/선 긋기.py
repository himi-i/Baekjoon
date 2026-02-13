import sys
input = sys.stdin.readline

n = int(input())
lines = []

for _ in range(n):
    start, end = map(int, input().split())
    lines.append((start, end))

lines.sort()

current_start, current_end = lines[0]
total_length = 0

for i in range(1, n):
    start, end = lines[i]
    
    if start <= current_end:
        current_end = max(current_end, end)
    
    else:
        total_length += current_end - current_start
        current_start, current_end = start, end

total_length += current_end - current_start

print(total_length)
