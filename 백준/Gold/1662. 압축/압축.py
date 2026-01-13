import sys
input = sys.stdin.readline

s = input().strip()
stack = []
length = 0

for i in range(len(s)):
    if s[i].isdigit():
        length += 1   # 일단 문자로 센다

    elif s[i] == '(':
        # 숫자 K는 길이에 포함되면 안 되므로 -1
        k = int(s[i-1])
        stack.append((length - 1, k))
        length = 0

    elif s[i] == ')':
        prev_length, k = stack.pop()
        length = prev_length + length * k

    else:
        length += 1

print(length)



