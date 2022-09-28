# KRUSKAL 알고리즘

<br>

🐶 일종의 그리디 알고리즘!!!🐶

<br>
<br>

## 🌈 간선을 하나씩 선택해서 MST를 찾는 알고리즘. - 간선 중심.

1. 최초, 모든 간선을 가중치에 따라 오름차순으로 <mark>정렬</mark>.

2. <mark>가중치가 가장 낮은 간선부터 선택</mark>하면서 트리를 증가시킴.
    - 사이클이 존재하면 다음으로 가중치가 낮은 간선 선택.

3. n-1개의 간선이 선택될 때까지 2번을 반복.
    - 그리디 적으로 최소를 선택하므로, 선택에 대해 뒤돌아 보지 않는다!!


<br>
<br>
<br>

### 🐳 최소의 가중치에 해당하는 간선을 하나씩 선택하면서 n-1개의 간선을 택할때 까지 그리디적으로 간선을 선택해, 최소 신장 트리를 만들어 가는 알고리즘!! 🐳 


### 🐳 사실상, 유니온 파인드 알고리즘에서 오름차순 정렬만 추가한 꼴이다. 🐳
 
<br>
<br>
<br>


## ✈️ 코드 구현 - Union find 자료구조 이용

```java
import java.io.*;
import java.util.*;

/**
 * path compression(경로 압축)을 사용한 방법.
 *
 * 크루스칼 알고리즘은 간선 중심으로 풀어가는 알고리즘이므로,
 *  간선 객체가 필요하고, 정보를 담는다.
 */

public class KruskalTest{

    static class Edge implements Comparable<Edge> {
        int from, to, weight;
        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o){
            // 비용이 양수와 음수가 섞이는 상황이라면 compare 함수를 사용하자.
//            return Integer.compare(this.weight, o.weight);
            return this.weight - o.weight;
        }
    }

    static int[] parents;       // 대표자(루트) 배열
    static int V, E;            // 노드, 간선의 갯수.
    static Edge[] edgeList;     // 간선들의 정보가 들어간 배열.

    /**
     * 유니온 파인드 알고리즘 구현.
     */

    static void make(){         // 크기가 1인 서로소 집합 생성.
        for(int i = 0; i < V; i++){     // 모든 노드가 자신을 부모로하는(대표자) 집합을 만듬.
            parents[i] = i;         // 자신의 부모는 자기자신.
        }
    }

    static int find(int a){     // a의 대표자 찾기.
        if(parents[a] == a) return a;       // 부모가 나 자신이라면 나는 루트. 대표자임.

        return parents[a] = find(parents[a]);       // 우리의 대표자를 나의 부모로. - path compression 기법.
        //return 문에 재귀함수를 넣어줌으로써,
        // 재귀를 타고 들어가는 과정에서 대표자를 계속 찾게 되고,
        // 빠져나오는 과정에서, 모든 노드들은 대표자로 갱신하게됨.
    }

    static boolean union(int a,int b){      // 리턴값 : true ==> union성공(사이클 발생x)
        // 각자 대표자를 찾기
        int aRoot = find(a);
        int bRoot = find(b);

        // 부모가 같다??? => 사이클 발생, 이미 한 집안(집합)이었구나!!
        if(aRoot == bRoot) return false;        //union 실패.

        // b집합을 a집합으로..흡수. => b의 대표자를 a의 대표자로.
        parents[bRoot] = aRoot;     // !! 중요 !! 대표자의 루트를 바꿔준다!!
        return true;                //union 성공.

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parents = new int[V];       // 노드의 갯수만큼 부모배열.
        edgeList = new Edge[E];     // 간선의 갯수만큼 간선 배열.

        for(int i = 0 ; i < E; i++){        // from, to, weight 순으로 간선의 정보 모두 저장.
            st = new StringTokenizer(br.readLine());
            edgeList[i] = new Edge(Integer.parseInt(st.nextToken()),
                                    Integer.parseInt(st.nextToken()),
                                    Integer.parseInt(st.nextToken()));
        }

        make();             // 각 노드들 집합화.
        Arrays.sort(edgeList);      //  간선들을 가중치 기준으로 오름차순.

        int result = 0;         // 최소 가중치의 총합
        int count = 0;          // 선택한 간선들의 갯수
        for(Edge edge : edgeList){      // 간선들을 하나씩 꺼내면서 확인.
            if(union(edge.from, edge.to)){      // 간선들이 사이클 돌지않고 잘 합쳐진다면,
                result += edge.weight;          // 가중치를 더하고,
                if(++count == V-1) break;       // 간선의 갯수가 n-1개가 되면 탈출.
            }
        }
        System.out.println(result);
    }
}


```
























