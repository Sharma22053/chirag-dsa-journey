class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        for(int i = 2*n -1;i>=0;i--){
            int curr = nums[i%n];
            while(!stack.empty() && stack.peek() <= curr){
                stack.pop();
            }

            if(i<n){
                result[i] = stack.empty()?-1:stack.peek();
            }

            stack.push(curr);
        }

        return result;
    }
}