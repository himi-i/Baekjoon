import sys
import heapq
input = sys.stdin.readline

Q = int(input())
event = {}
sum = 0

for _ in range(Q):
    data = input().split()
    num = int(data[0])
    if num == 1:
        name = data[1]

        if name not in event:
            event[name] = []

        for value in data[3:]:
            heapq.heappush(event[name], -int(value))
    else:
        name = data[1]
        b = int(data[2])
        if name not in event:
            continue
        for _ in range(b):
            if not event[name]:
                break
            value = heapq.heappop(event[name])
            sum += -value

print(sum)






