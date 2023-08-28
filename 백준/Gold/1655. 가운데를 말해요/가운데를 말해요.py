import heapq
import sys

input = sys.stdin.readline

n = int(input())

max_heap = []
min_heap = []

for i in range(n):
    x = int(input())
    if i % 2 == 0:
        heapq.heappush(max_heap, -x)
    else:
        heapq.heappush(min_heap, x)

    if max_heap and min_heap and -max_heap[0] > min_heap[0]:
        maxnum = -heapq.heappop(max_heap)
        minnum = heapq.heappop(min_heap)

        heapq.heappush(max_heap, -minnum)
        heapq.heappush(min_heap, maxnum)

    print(-max_heap[0])
