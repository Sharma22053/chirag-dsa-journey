class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DisjoinSet djs = new DisjoinSet(c+1);
        for(int[] connection : connections){
            djs.unionBySize(connection[0],connection[1]);
        }

        boolean[] online = new boolean[c+1];
        int[] offline = new int[c+1];
        Arrays.fill(online,true);
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int[] query : queries){
            int operation = query[0];
            int grid = query[1];
            if(operation == 2){
                online[grid] = false;
                offline[grid]++;
            }
        }

        for(int i=1;i<=c;i++){
            int root = djs.findParent(i);
            if(!hmap.containsKey(root)){
                hmap.put(root,-1);
            }
            int station = hmap.get(root);
            if(online[i]){
                if(station == -1 || station > i){
                    hmap.put(root,i);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=queries.length-1;i>=0;i--){
            int operation = queries[i][0];
            int x = queries[i][1];
            int root = djs.findParent(x);
            int station = hmap.get(root);
            if(operation == 1){
                if(online[x]) result.add(x);
                else result.add(station);
            }
            if(operation == 2){
                if(offline[x] > 1){
                    offline[x]--;
                } else {
                    online[x] = true;
                    if(station == -1 || station > x){
                        hmap.put(root,x);
                    }
                }
            }
        }
        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();

    }
}

class DisjoinSet {
    int[] size;
    int[] parent;
    public DisjoinSet(int n){
        size = new int[n];
        parent = new int[n];
        for(int i=0;i<n;i++){
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findParent(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }

    public void unionBySize(int u,int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

    if(ulp_u == ulp_v){
        return;
    } else if(size[ulp_u] < size[ulp_v]){
        parent[ulp_u] = ulp_v;
        size[ulp_v] += size[ulp_u];
    } else{
        parent[ulp_v] = ulp_u;
        size[ulp_u] += size[ulp_v];
    }
    }}