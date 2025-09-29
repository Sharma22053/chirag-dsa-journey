class Solution {
    int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int maximum = 0;
        DisjoinSet djs = new DisjoinSet(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    for(int[] dir : directions){
                        int newRow = i + dir[0];
                        int newCol = j + dir[1];
                        if(isValid(newRow,newCol,n) && grid[newRow][newCol] == 1){
                            int nodeNumber = i * n + j;
                            int newNodeNumber = newRow * n + newCol;
                            djs.unionBySize(nodeNumber,newNodeNumber);

                        }
                    }
                } else {
                    continue;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) continue;
                HashSet<Integer> set = new HashSet<>();
                for(int[] dir : directions){
                    int newRow = dir[0] + i;
                    int newColumn = dir[1] + j;
                    if(isValid(newRow,newColumn,n) && grid[newRow][newColumn] == 1){
                        set.add(djs.findParent(newRow * n + newColumn));
                    }
                }
                int sizeTotal = 0;
                for(Integer parents : set){
                    sizeTotal += djs.size[parents];

                }
                maximum = Math.max(sizeTotal+1,maximum);
            }
        }
        for(int i=0;i<n*n;i++){
            maximum = Math.max(maximum,djs.size[djs.findParent(i)]);
        }
        return maximum;


    }
    private boolean isValid(int row,int column,int n){
        return row>=0 && column >=0 && row<n && column <n;
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

