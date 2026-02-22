import sys
input = sys.stdin.readline

stack = []
line = input().strip()
result = 0
temp = 1

for i in range(len(line)):
    ch = line[i]

    if ch == "(":
        stack.append(ch)
        temp *= 2

    elif ch == "[":
        stack.append(ch)
        temp *= 3

    elif ch == ")":
        if not stack or stack[-1] != "(":
            print(0)
            exit()

        if line[i-1] == "(":
            result += temp

        stack.pop()
        temp //= 2

    elif ch == "]":
        if not stack or stack[-1] != "[":
            print(0)
            exit()

        if line[i-1] == "[":
            result += temp

        stack.pop()
        temp //= 3

if stack:
    print(0)
else:
    print(result)
  
        

    







