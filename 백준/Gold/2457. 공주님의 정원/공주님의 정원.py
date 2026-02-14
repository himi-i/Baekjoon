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
count = 0
idx = 0

while current <= target:
    max_end = current

    while idx < N and flower[idx][0] <= current:
        if flower[idx][1] > max_end:
            max_end = flower[idx][1]
        idx += 1

    if max_end == current:
        print(0)
        break

    count += 1
    current = max_end
else:
    print(count)
