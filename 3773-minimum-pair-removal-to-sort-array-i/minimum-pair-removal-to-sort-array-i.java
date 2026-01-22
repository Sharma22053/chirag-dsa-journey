class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        int count = 0;
        while (list.size() > 1) {
            var isAscending = true;
            var minSum = Integer.MAX_VALUE;
            var target = -1;
            for (int i = 0; i < list.size() - 1; i++) {
                var sum = list.get(i) + list.get(i + 1);
                if (list.get(i) > list.get(i + 1))
                    isAscending = false;
                if (sum < minSum) {
                    minSum = sum;
                    target = i;
                }
            }

            if (isAscending)
                break;
            count++;
            list.set(target, minSum);
            list.remove(target + 1);
        }
        return count;
    }
}