import sys
input = sys.stdin.readline

N = int(input())
balloons = list(map(int, input().split()))

arrow = [0] * 1000001  
answer = 0

for h in balloons:
    if arrow[h] > 0:
        arrow[h] -= 1
    else:
        answer += 1
    arrow[h - 1] += 1

print(answer)
