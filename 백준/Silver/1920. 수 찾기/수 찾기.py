import sys
input = sys.stdin.readline

n = int(input())

arr = list(map(int, input().split()))
arr.sort()

m = int(input())
arr2 = list(map(int, input().split()))

def binary_search(target):
    left = 0
    right = n - 1

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] == target:
            return 1
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
        
    return 0
    
for x in arr2:
    print(binary_search(x))





