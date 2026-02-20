import sys
input = sys.stdin.readline

N, K = map(int, input().split())

dp = [0] * (K + 1)

for _ in range(N):
    w, v = map(int, input().split())

    for weight in range(K, w - 1, -1):
        dp[weight] = max(dp[weight], dp[weight - w] + v)

print(dp[K])