class Solution {
    public int findCenter(int[][] edges) {
        int[] firstNode = edges[0];
        int[] secondNode = edges[1];

        return firstNode[0] == secondNode[0] || firstNode[0] == secondNode[1] ? firstNode[0] : firstNode[1];
    }
}