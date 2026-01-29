import sys
input = sys.stdin.readline
 
N = int(input())
arr = [int(input()) for _ in range(N)]

arr.sort(reverse=True)

for x in range(N-2):
    if arr[x] < arr[x+1] + arr[x+2]:
        print(arr[x] + arr[x+1] + arr[x+2])
        break
    else:
        if x == N - 3:
            print(-1)




