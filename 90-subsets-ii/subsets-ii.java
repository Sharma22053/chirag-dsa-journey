class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }

    static void generateSubsets(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums, int start) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            temp.add(nums[i]);
            generateSubsets(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);

        }
    }
}