class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] cost = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(cost[i],Integer.MAX_VALUE);
            cost[i][i] = 0;
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            cost[from][to] = weight;
            cost[to][from] = weight;
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cost[i][via] != Integer.MAX_VALUE && cost[via][j] != Integer.MAX_VALUE) {
                        cost[i][j] = Math.min(cost[i][j], cost[i][via] + cost[via][j]);
                    }
                }
            }
        }

         int minReachable = Integer.MAX_VALUE, bestCity = -1;
        for (int city = 0; city < n; city++) {
            int reachableCount = 0;
            for (int other = 0; other < n; other++) {
                if (city != other && cost[city][other] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            if (reachableCount <= minReachable) {
                minReachable = reachableCount;
                bestCity = city;
            }
        }

        return bestCity;
    }
}