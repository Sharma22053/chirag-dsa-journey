class Solution {
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> stack = new Stack<>();


        for(int i= prices.length-1;i>=0;i--){
            while(!stack.empty()&& stack.peek() > prices[i]){
                stack.pop();
            }

            int discount = stack.empty() ? 0 : stack.peek();
            result[i] = prices[i] - discount;
            stack.push(prices[i]);
        }

        return result;
    }
}