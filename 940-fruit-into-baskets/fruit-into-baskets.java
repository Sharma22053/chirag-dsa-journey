class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int right = 0, left = 0, result = 0;
        while (right < n) {
            hmap.put(fruits[right], hmap.getOrDefault(fruits[right], 0) + 1);
            if (hmap.size() <= 2) {
                result = Math.max(result, right - left + 1);
            } else {
                hmap.put(fruits[left], hmap.get(fruits[left]) - 1);
                if (hmap.get(fruits[left]) == 0) {
                    hmap.remove(fruits[left]);
                }
                left++;
            }
            right++;
        }
        return result;
    }
}