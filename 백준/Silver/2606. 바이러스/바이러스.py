def dfs(graph, start, visit):
    visit[start] = 1
    # print(start, end=' ')
    for v in graph[start]:
        if visit[v] == 0:
            dfs(graph, v, visit)

n = int(input())
v = int(input())
mygraph = [[] for i in range(n+1)]
for i in range(v):
    e1, e2 = map(int, input().split())
    mygraph[e1] += [e2]
    mygraph[e2] += [e1]



visited = [0] * (n+1)
dfs(mygraph, 1, visited)

print(sum(visited)-1)
