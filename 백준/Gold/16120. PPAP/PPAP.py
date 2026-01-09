import sys
input = sys.stdin.readline

s = input().strip()
stack = []

for ch in s:
    stack.append(ch)
       
    if len(stack) >= 4 and stack[-4:] == ['P', 'P', 'A', 'P']:
        for _ in range(4):
            stack.pop()
        stack.append('P')

if stack == ['P']:
    print("PPAP")
else:
    print("NP")
