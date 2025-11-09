class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjoinSet djsAlice = new DisjoinSet(n);
        DisjoinSet djsBob = new DisjoinSet(n);
        int count = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                count += (djsAlice.unionBySize(edge[1]-1, edge[2]-1) |
                        djsBob.unionBySize(edge[1]-1, edge[2]-1));
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 2)
                count += djsBob.unionBySize(edge[1]-1, edge[2]-1);
            else if (edge[0] == 1)
                count += djsAlice.unionBySize(edge[2]-1, edge[1]-1);
        }
        if(djsAlice.isConnected() && djsBob.isConnected()){
            return edges.length - count;
        }
        return -1;

    }
}

class DisjoinSet {
    int[] size;
    int[] parent;
    int components;

    public DisjoinSet(int n) {
        components = n;
        size = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }

    public int unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if (ulp_u == ulp_v) {
            return 0;
        } else if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
        components--;
        return 1;
    }
    boolean isConnected(){
        return components==1;
    }
}
