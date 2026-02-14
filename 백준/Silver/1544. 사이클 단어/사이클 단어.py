import sys
input = sys.stdin.readline

N = int(input())
words = []
count = 0

for _ in range(N):
    word = input().strip()
    
    is_new = True
    
    for w in words:
        if len(w) == len(word) and word in (w + w):
            is_new = False
            break
    
    if is_new:
        words.append(word)
        count += 1

print(count)
