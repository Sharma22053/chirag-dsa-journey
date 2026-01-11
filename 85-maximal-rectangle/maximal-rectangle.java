class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int column = matrix[0].length;
        int[] heights = new int[column];
        for (char[] row : matrix) {
            for (int i = 0; i < column; i++) {
                heights[i] = (row[i] == '1')? heights[i]+1:0;
            }
            maxArea = Math.max(maxArea,helper(heights));
        }

        return maxArea;
    }

    private int helper(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && (i == n || heights[stack.peek()] >= heights[i])) {
                int element = heights[stack.peek()];
                stack.pop();
                int width = stack.empty() ? i : i - stack.peek() - 1;
                area = Math.max(area, element * width);
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            int height = heights[stack.pop()];
            int width = stack.empty() ? n : n - stack.peek() - 1;
            area = Math.max(area, height * width);
        }
        return area;
    }
}