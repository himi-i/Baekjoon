import sys
input = sys.stdin.readline

first = input().strip()
second = input().strip()

f_l = len(first)
s_l = len(second)

dp = [[0] * (s_l + 1) for _ in range(f_l + 1)]

for i in range(1, f_l + 1):
    for j in range(1, s_l + 1):
        if first[i-1] == second[j-1]:

            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i][j-1], dp[i-1][j])

print(dp[f_l][s_l])



