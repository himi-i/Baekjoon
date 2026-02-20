import sys
input = sys.stdin.readline

K, N = map(int, input().split())

arr = [int(input()) for _ in range(K)]


left = 1
right = max(arr)


result = 0

while left <= right:
    mid = (left + right) // 2
    count = 0

    for x in arr:
        count += x // mid

    if count >= N:
        left = mid + 1
        result = max(result, mid)
    else:
        right = mid - 1

print(result)






