import sys
input = sys.stdin.readline

n = int(input())

max_dp = [0, 0, 0]
min_dp = [0, 0, 0]

for i in range(n):
    a, b, c = map(int, input().split())

    if i == 0:
        max_dp = [a, b, c]
        min_dp = [a, b, c]
        continue

    new_max = [0, 0, 0]
    new_min = [0, 0, 0]

    new_max[0] = max(max_dp[0], max_dp[1]) + a
    new_max[1] = max(max_dp[0], max_dp[1], max_dp[2]) + b
    new_max[2] = max(max_dp[1], max_dp[2]) + c

    new_min[0] = min(min_dp[0], min_dp[1]) + a
    new_min[1] = min(min_dp[0], min_dp[1], min_dp[2]) + b
    new_min[2] = min(min_dp[1], min_dp[2]) + c

    max_dp = new_max
    min_dp = new_min

print(max(max_dp), min(min_dp))