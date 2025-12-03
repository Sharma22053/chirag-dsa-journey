class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adjacency = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Set<Integer>> setList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency.add(new ArrayList<>());
            result.add(new ArrayList<>());
            setList.add(new HashSet<>());
        }
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            adjacency.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            temp.add(node);
            for (int neighbour : adjacency.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0)
                    queue.offer(neighbour);
            }
        }

        for (int node : temp) {
            for (int neighbour : adjacency.get(node)) {
                setList.get(neighbour).add(node);
                setList.get(neighbour).addAll(setList.get(node));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int node = 0; node < n; node++) {
                if (node == i)
                    continue;
                if (setList.get(i).contains(node)) {
                    result.get(i).add(node);
                }
            }
        }
        return result;
    }
}