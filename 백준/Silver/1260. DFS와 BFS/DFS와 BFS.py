import queue

def bfs(graph, start):
    visited = { start }
    que = queue.Queue()
    que.put(start)
    while not que.empty():
        v = que.get()
        print(v, end=' ')
        for u in graph[v]:
            if u not in visited:
                visited.add(u)
                que.put(u)
    return visited

def dfs(graph, start, visit):
    visit.add(start)
    print(start, end=' ')
    for v in graph[start]:
        if v not in visit:
            dfs(graph, v, visit)
    return visit


mygraph = {}
n, m, v = map(int, input().split())
adj = [[] for _ in range(n+1)]


for _ in range(m):
    # 간선 입력
    v1, v2 = map(int, input().split())
    # 양방향 그래프
    adj[v1].append(v2)
    adj[v2].append(v1)

for edges in adj:
    edges.sort()


dfs(adj, v, set())
print()
bfs(adj, v)
print()
