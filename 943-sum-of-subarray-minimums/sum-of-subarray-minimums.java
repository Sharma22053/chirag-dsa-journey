class Solution {
    int mod = 1000000007;
    
    public int sumSubarrayMins(int[] arr) {
        int[] nextSmaller = nextSmallerElement(arr);
        int[] previousSmaller = previousSmallerElement(arr);
        long sum =0;
        for(int i = 0;i<arr.length;i++){
            int nSmaller = nextSmaller[i] - i;
            int pSmaller = i - previousSmaller[i];
            long contribution = ((long)nSmaller * pSmaller% mod * arr[i]% mod) % mod;
            sum = (sum + contribution)%mod;
        }
        return (int)sum;

    }
    static int[] nextSmallerElement(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for(int i= arr.length-1;i>=0;i--){
            while(!stack.empty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            result[i] = stack.empty()?arr.length:stack.peek();
            stack.push(i);
        }
        return result;
    }

    static int[] previousSmallerElement(int[] arr){
         Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for(int i=0;i < arr.length;i++){
            while(!stack.empty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }

            result[i] = stack.empty()?-1:stack.peek();
            stack.push(i);
        }
        return result;
    }
}