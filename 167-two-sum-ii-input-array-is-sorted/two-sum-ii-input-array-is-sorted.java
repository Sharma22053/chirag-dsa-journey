class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int targetIndex = binarySearch(numbers, target - numbers[i], i + 1, n - 1);
            if (targetIndex != -1)
                return new int[] { i + 1, targetIndex + 1 };
        }
        return new int[] { -1, -1 };
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}