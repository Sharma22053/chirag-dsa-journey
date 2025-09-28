class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int count = 0;
        DisjoinSet djs = new DisjoinSet(200001);
        Set<Integer> uniqueNodes = new HashSet<>();
        for(int[] stone : stones){
            int u = stone[0];
            int v = stone[1] + 10001;
            djs.unionBySize(u,v); 
            uniqueNodes.add(u);
            uniqueNodes.add(v);         
        }
        int components = 0;
        for(int node : uniqueNodes){
            if(djs.findParent(node) == node) components++;
        }
        return n-components;
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
