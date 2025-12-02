class Solution {
    public int[] findOrder(int v, int[][] arr) {

        int indegree[] = new int[v];
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;

        // build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());

        // IMPORTANT: arr[i] = [a, b] means b -> a
        for (int i = 0; i < n; i++) {
            int a = arr[i][0];
            int b = arr[i][1];
            adj.get(b).add(a);      // b -> a
            indegree[a]++;         // indegree of 'a' increases
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                ans.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int m : adj.get(node)) {
                indegree[m]--;
                if (indegree[m] == 0) {
                    q.add(m);
                    ans.add(m);
                }
            }
        }

        if (ans.size() != v) return new int[]{}; // cycle

        int[] arr1 = ans.stream().mapToInt(i -> i).toArray();
        return arr1;
    }
     
}