import sys
input = sys.stdin.readline

N = int(input())
flower = []

for _ in range(N):
    s_m, s_d, e_m, e_d = map(int, input().split())
    flower.append(((s_m, s_d), (e_m, e_d)))

flower.sort(key=lambda x: (x[0][0], x[0][1]))

current = (3, 1)        
target = (11, 30)       
idx = 0
count = 0

while current <= target:
    max_end = current
    found = False

    while idx < N and flower[idx][0] <= current:
        if flower[idx][1] > max_end:
            max_end = flower[idx][1]
            found = True
        idx += 1

    if not found:
        print(0)
        sys.exit()

    count += 1
    current = max_end

print(count)
