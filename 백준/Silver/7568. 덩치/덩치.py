import sys
input = sys.stdin.readline

N = int(input())
people = []

for _ in range(N):
    x, y = map(int, input().split())
    people.append([x, y])

rank = []
for i in range(N):
    count = 0
    for j in range(N):
        if i != j:
            if people[i][0] < people[j][0] and people[i][1] < people[j][1]:
                count += 1
    rank.append(count + 1)

print(*rank)

    


