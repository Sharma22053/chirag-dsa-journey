class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        DisjoinSet djs = new DisjoinSet(n);
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int[] edge : edges){ 
            djs.unionBySize(edge[0],edge[1]);
        }
        for(int[] edge : edges){
            int root = djs.findParent(edge[0]);
            hmap.put(root,hmap.getOrDefault(root,0) + 1);
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(djs.findParent(i) == i){
                int nodeCount = djs.size[i];
                int edgeCount = (nodeCount * (nodeCount -1)) / 2;
                if(hmap.getOrDefault(i,0) == edgeCount) count++;
            }
        }
        return count;
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
    }
}


