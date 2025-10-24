class Solution {
    public int nextBeautifulNumber(int n) {
        List<Integer> list = new ArrayList<>();
        helper(0,new int[10],list);
        Collections.sort(list);
        for(int i : list){
            if(i > n) return i;
        }
        return -1;
    }

    private void helper(long num, int[] count, List<Integer> list) {
        if (num > 0 && isBeautiful(count)) {
            list.add((int) num);
        }
        if (num > 1224444)
            return;
        for (int i = 1; i <= 7; i++) {
            if (count[i] < i) {
                count[i]++;
                helper(num * 10 + i, count, list);
                count[i]--;
            }
        }
    }

    private boolean isBeautiful(int[] count) {
        for (int i = 1; i <= 7; i++) {
            if (count[i] != 0 && count[i] != i)
                return false;
        }
        return true;
    }
}