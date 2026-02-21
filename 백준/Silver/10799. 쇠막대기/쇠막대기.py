import sys
input = sys.stdin.readline

s = input().strip()

stack = []
result = 0

for i in range(len(s)):
    if s[i] == "(":
        stack.append("(")
    else:  
        stack.pop()

        if s[i - 1] == "(":
            result += len(stack)
        else:
            result += 1

print(result)