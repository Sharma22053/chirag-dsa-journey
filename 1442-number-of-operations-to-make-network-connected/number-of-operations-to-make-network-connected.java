class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        DisjoinSet djs = new DisjoinSet(n);
        int connection = n;
        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];
            if(djs.findParent(u) != djs.findParent(v)){
                connection--;
                djs.unionBySize(u,v);
            }
        }
        return connection-1;
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
