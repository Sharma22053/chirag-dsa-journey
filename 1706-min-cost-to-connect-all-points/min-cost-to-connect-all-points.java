class Solution {
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0)
            return -1;
        int edges = 0;
        int n = points.length;
        int totalWeight = 0;
        DisjoinSet djs = new DisjoinSet(n);
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            int[] coordinates = points[i];
            int x1 = coordinates[0];
            int y1 = coordinates[1];
            for (int j = i + 1; j < n; j++) {
                int[] coordinates2 = points[j];
                int x2 = coordinates2[0];
                int y2 = coordinates2[1];

                int weight = Math.abs(x1-x2) + Math.abs(y1-y2);
                queue.offer(new int[] {i,j,weight});
            }
        }

        while(!queue.isEmpty() && edges < n-1){
            int[] edge = queue.poll();
            if(djs.isConnected(edge[0] , edge[1])) continue;
            djs.unionBySize(edge[0],edge[1]);
            totalWeight += edge[2];
            edges++;

        }
        return totalWeight;
    }
}

class DisjoinSet {
    int[] size;
    int[] parent;

    public DisjoinSet(int n) {
        size = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if (ulp_u == ulp_v) {
            return;
        } else if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
    public boolean isConnected(int x,int y){
        return findParent(x) == findParent(y);
    }
}
