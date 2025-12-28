class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (helper(nums1[i], nums2)) {
                set.add(nums1[i]);
            }
        }

        int[] result = new int[set.size()];
        int i = 0;
        for (Integer x : set) {
            result[i++] = x;
        }
        return result;
    }

    private boolean helper(int target, int[] arr) {
        
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}