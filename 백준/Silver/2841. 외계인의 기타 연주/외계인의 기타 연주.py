import sys
from collections import deque

input = sys.stdin.readline

# 파이썬에는 스택이라는 함수가 없고 그냥 리스트형태에서 꺼내쓴다.

N, P = map(int, input().split())
stacks = [[] for _ in range(7)]
count = 0

for _ in range(N):
    x, y = map(int, input().split()) # 여기서 스택은 항상 오름차순!! -> 띠라서 pop만 가지고 비교해서 가능
    stack = stacks[x]

    #뗄 때
    while stack and stack[-1] > y :
        stack.pop()
        count += 1
    
    #누를 때
    if not stack or stack[-1] < y:
        stack.append(y)
        count += 1

print(count)

        


