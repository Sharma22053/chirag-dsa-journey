class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int minSum = 0, maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);
            maxHeap.offer(nums[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        while (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
            minSum += maxHeap.poll();
            maxSum += minHeap.poll();
        }
        return Math.abs(maxSum - minSum);

    }
}