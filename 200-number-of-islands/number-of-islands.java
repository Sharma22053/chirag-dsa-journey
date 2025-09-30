class Solution {
    int[][] directions = {{0,1},{-1,0},{0,-1},{1,0}};
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        Set<Integer> set = new HashSet<>();
        DisjoinSet djs = new DisjoinSet(row*column);
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j] == '0')continue;
                for(int[] dir: directions){
                    int newRow = i + dir[0];
                    int newColumn = j + dir[1];
     if(isValid(newRow,newColumn,row,column) && grid[newRow][newColumn] == '1'){
                        int nodeNumber = i * column + j;
                        int newNodeNumber = newRow * column + newColumn;
                        djs.unionBySize(nodeNumber,newNodeNumber);
                    }
                }
            }
        }

        
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j] == '0') continue;
                int nodeNumber = i * column + j;
                set.add(djs.findParent(nodeNumber));
                }
            }
            return set.size();
        }

    private boolean isValid(int row,int column,int rowLength,int colLength){
        return row>= 0 && column>=0 && row < rowLength && column < colLength;
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


