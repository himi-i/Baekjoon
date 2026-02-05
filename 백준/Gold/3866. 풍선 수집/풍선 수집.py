import sys
from collections import defaultdict

INF = 10**18
input = sys.stdin.readline

while True:
    n = int(input())
    if n == 0:
        break

    p = [0] * (n + 1)
    t = [0] * (n + 1)

    for i in range(1, n + 1):
        p[i], t[i] = map(int, input().split())

    # dp[i] : i번째 풍선까지 처리한 상태들
    # key = (위치, 들고있는 개수)
    # value = 최소 이동 거리
    dp = defaultdict(lambda: INF)
    dp[(0, 0)] = 0  # 시작: 집, 풍선 0개

    possible = True

    for i in range(1, n + 1):
        next_dp = defaultdict(lambda: INF)
        found = False

        for (pos, k), dist in dp.items():
            # 현재 시간은 이전 풍선 시간
            cur_time = t[i - 1] if i > 1 else 0

            # -----------------
            # 1️⃣ 바로 풍선으로 이동
            move_time = abs(pos - p[i]) * (k + 1)
            if cur_time + move_time <= t[i]:
                if k < 3:
                    nd = dist + abs(pos - p[i])
                    key = (p[i], k + 1)
                    next_dp[key] = min(next_dp[key], nd)
                    found = True

            # -----------------
            # 2️⃣ 집에 들렀다 이동
            # pos → 집 → 풍선
            time_to_home = abs(pos) * (k + 1)
            time_home_to_balloon = abs(p[i]) * 1

            total_time = cur_time + time_to_home + time_home_to_balloon
            if total_time <= t[i]:
                nd = dist + abs(pos) + abs(p[i])
                key = (p[i], 1)
                next_dp[key] = min(next_dp[key], nd)
                found = True

        if not found:
            print(f"NG {i}")
            possible = False
            break

        dp = next_dp

    if not possible:
        continue

    # 마지막에 집으로 돌아오는 비용
    answer = INF
    for (pos, k), dist in dp.items():
        answer = min(answer, dist + abs(pos))

    print(f"OK {answer}")
