class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i = nums2.length-1;i>=0;i--){
            if(stack.empty()){
                stack.push(nums2[i]);
                hmap.put(nums2[i],-1);
            } else if(nums2[i] < stack.peek()){
                hmap.put(nums2[i],stack.peek());
                stack.push(nums2[i]);              
            } else {
                while(!stack.empty() && stack.peek() <= nums2[i]){
                    stack.pop();
                }
                hmap.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
                stack.push(nums2[i]);
            }
        }

        int[] result = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int temp = hmap.get(nums1[i]);
            result[i] = temp;
        }

        return result;

    }
}