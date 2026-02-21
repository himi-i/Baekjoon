import sys
input = sys.stdin.readline

while True:
    line = input().rstrip()

    if line == ".":
        break

    stack = []
    state = True

    for ch in line:
        if ch == "(" or ch == "[":
            stack.append(ch)

        elif ch == ")":
            if not stack or stack[-1] != "(":
                state = False
                break
            stack.pop()

        elif ch == "]":
            if not stack or stack[-1] != "[":
                state = False
                break
            stack.pop()

    if stack:
        state = False

    if state:
        print("yes")
    else:
        print("no")