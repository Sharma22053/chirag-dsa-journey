class Solution {
    public int minPartitions(String n) {
        int count = 0;
        for (int i = 0; i < n.length(); i++) {
            int temp = n.charAt(i) - '0';
            count = Math.max(count, temp);
        }
        return count;
    }
}