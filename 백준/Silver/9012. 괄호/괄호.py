import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    data = input().strip()

    stack = []
    state = True

    for x in data:
        if x == '(':
            stack.append(x)
        else:
            if not stack:
                state = False
                break
            stack.pop()

    if stack:
        state = False
        
    if state:
        print("YES")
    else:
        print("NO")



