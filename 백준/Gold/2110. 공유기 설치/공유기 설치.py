import sys
input = sys.stdin.readline

N, C = map(int, input().split())

home = [int(input()) for _ in range(N)]

home.sort()
left = 1
right = home[-1] - home[0]
result = 0

while left <= right:
    mid = (left + right) // 2 # 공유기 사이의 최대 거리

    count = 1

    x = home[0]
    for i in range(1, N):
        if home[i] - x >= mid: # 최소거리를 보장할 수 있는지 확인
            count += 1
            x = home[i]
    
    if count >= C:
        result = mid
        left = mid + 1
    else:
        right = mid -1

print(result)



