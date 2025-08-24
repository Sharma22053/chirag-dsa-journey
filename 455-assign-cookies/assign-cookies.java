class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int left = 0 , right = 0;
        while(right < g.length && left<s.length){
            if(s[left] >= g[right]){
                right++;
            }
            left++;
        }

        return right;
    }
}