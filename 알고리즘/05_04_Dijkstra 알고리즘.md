# Dijkstra 알고리즘

## 🌈 특징

- 시작 정점에서 다른 모든 정점으로의 최단 경로를 구하는 알고리즘.

- 시작 저점에서의 거리가 최소인 정점을 선택해 나가면서 최단 경로를 구함.

- 탐욕 기법을 사용한 알고리즘으로 MST의 프림 알고리즘과 유사.

## 🌈 프림 vs 다익스트라

- 프림은 출발지점 중심의 생각이고, 다익스트라는 경유지점 중심의 생각.

- 프림은 출발지에 서서 이제 갈길들 중에 최소의 길을 선택한다.

  - 최적 경로 선택.

- 다익스트라는 경유지점에 서있다 가정하고, 현재 지점을 경유했을때, 갈수 있는 경로들의 최적 비용들을 갱신 하면서, 또 다음갈수 있는 경로중 최적의 경로를 선택.
  - 최적의 경로 선택 + 현재 지점을 경유했을때 다음 경로들의 최적해 갱신.

## 코드 구현 🌈

- now와 next는 간선, now.to와 next.to는 정점이라는 사실이 헷갈리면안됨!!!
  - 방문체크 : 정점
  - 최소 가중치 : 간선비교

```java
import java.io.*;
import java.util.*;


/**
 * 다익스트라 알고리즘
 * - 인접 리스트. / 유향 그래프시
 */

public class Main {
    static class Edge implements Comparable<Edge>{
        int to, weight;
        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o){
            return this.weight - o.weight;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int V, E;
    static List<Edge>[] adjList;
    static int[] dist;

    static void Dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V];
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()){
            Edge now = pq.poll();       // 간선을 꺼냄.

            if(visited[now.to]) continue;

            // 다음 경유지 선택.
            visited[now.to] = true;
            // 그 경유지로 타고 갈수 있는 노드들 탐색.
            for(Edge next : adjList[now.to]){       // now.to를 거쳐갈수 있는 노드들 탐색.
                if(!visited[next.to] && dist[next.to] > dist[now.to] + next.weight){
                    // 방문하지 않았고, "경유지까지 비용 + 요기서 다음 경로 비용 < 기존의 다음 경로 비용" 일때. 갱신
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.add(new Edge(next.to, dist[next.to]));   // 큐에 삽입.
                }
            }

        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[];
        for(int i  =0; i < V; i++){
            adjList[i] = new ArrayList<>();
        }
        dist = new int[V];
        Arrays.fill(dist, INF);

        for(int i = 0; i < E; i++){
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new Edge(to, weight));
        }

        Dijkstra(0);

    }
}

```
