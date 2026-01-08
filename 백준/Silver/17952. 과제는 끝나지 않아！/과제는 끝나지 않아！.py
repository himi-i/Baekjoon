import sys
input = sys.stdin.readline

N = int(input())
score = 0
stack = []

for _ in range(N):
    data = list(map(int, input().split()))

    if data[0] == 1:              # 새로운 과제
        A, T = data[1], data[2]
        stack.append([A, T])

    if stack:                     # 현재 하고 있는 과제 
        stack[-1][1] -= 1

        if stack[-1][1] == 0:    
            score += stack[-1][0]
            stack.pop()

print(score)
