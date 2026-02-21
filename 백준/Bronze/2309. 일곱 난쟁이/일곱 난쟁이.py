import sys
input = sys.stdin.readline

arr = [int(input()) for _ in range(9)]
total = sum(arr)

found = False

for i in range(8):
    for j in range(i + 1, 9):
        if total - arr[i] - arr[j] == 100:
            result = [arr[k] for k in range(9) if k != i and k != j]
            result.sort()
            print(*result, sep="\n")
            found = True
            break
    if found:
        break