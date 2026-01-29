import sys

input = sys.stdin.readline

n = int(input())
sort = []

for _ in range(n):
    sort.append(int(input()))

sort.sort()

for x in sort:
    print(x)



