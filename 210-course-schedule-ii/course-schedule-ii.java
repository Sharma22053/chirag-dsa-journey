class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int[] result = new int[numCourses];
        int index = 0;
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            adjacency.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[index++] = node;
            for (int neighbour : adjacency.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return index == numCourses ? result : new int[0];
    }

}