import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [int(input()) for _ in range(N)]

tree = [(0, 0)] * (4 * N)

def build(node, start, end):
    if start == end:
        tree[node] = (arr[start], arr[start])
        return tree[node]

    mid = (start + end) // 2
    left = build(node * 2, start, mid)
    right = build(node * 2 + 1, mid + 1, end)

    tree[node] = (min(left[0], right[0]), max(left[1], right[1]))
    return tree[node]

def query(node, start, end, left, right):
    if right < start or end < left:
        return (float('inf'), -float('inf'))

    if left <= start and end <= right:
        return tree[node]

    mid = (start + end) // 2
    l = query(node * 2, start, mid, left, right)
    r = query(node * 2 + 1, mid + 1, end, left, right)

    return (min(l[0], r[0]), max(l[1], r[1]))

build(1, 0, N - 1)

for _ in range(M):
    a, b = map(int, input().split())
    mn, mx = query(1, 0, N - 1, a - 1, b - 1)
    print(mn, mx)