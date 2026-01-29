import sys
input = sys.stdin.readline

N, C = map(int, input().split())
nums = list(map(int, input().split()))

count = {}
order = {}

idx = 0
for x in nums:
    if x not in count:
        count[x] = 1
        order[x] = idx
        idx += 1
    else:
        count[x] += 1

sorted_nums = sorted(count.items(),
                     key=lambda x: (-x[1], order[x[0]]))

for num, cnt in sorted_nums:
    print((str(num) + ' ') * cnt, end='')
