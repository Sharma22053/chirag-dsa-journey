class Solution {
    public int minPartitions(String n) {
        int count = 0;
        for (int i = 0; i < n.length(); i++) {
            if(n.charAt(i) - '0' == 9) return 9;
            count = Math.max(count, (n.charAt(i) - '0'));
        }
        return count;
    }
}