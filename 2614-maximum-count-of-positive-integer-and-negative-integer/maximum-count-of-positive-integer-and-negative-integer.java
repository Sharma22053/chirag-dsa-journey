class Solution {
    public int maximumCount(int[] nums) {

        return Math.max(nums.length - upperBound(nums), lowerBound(nums));
    }

    private int lowerBound(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int index = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < 0) {
                low = mid + 1;
            } else if (nums[mid] >= 0) {
                high = mid - 1;
                index = mid;
            }
        }
        return index;
    }

    private int upperBound(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int index = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= 0) {
                low = mid + 1;
            } else if (nums[mid] > 0) {
                high = mid - 1;
                index = mid;
            }
        }
        return index;
    }
}