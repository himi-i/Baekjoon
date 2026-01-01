import sys

input = sys.stdin.readline

T = int(input())

for i in range(1, T + 1):
    words = input().split()  

    print(f"Case #{i}:", " ".join(words[::-1]))
    