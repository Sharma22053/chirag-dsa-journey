import java.util.Stack;

class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] height = new int[n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            // Update height array
            for (int j = 0; j < n; j++) {
                height[j] = mat[i][j] == 1 ? height[j] + 1 : 0;
            }

            // Use Stack instead of Deque
            Stack<int[]> stack = new Stack<>();
            int curr = 0;
            for (int h : height) {
                int cnt = 1;
                while (!stack.isEmpty() && stack.peek()[0] >= h) {
                    int[] top = stack.pop();
                    curr -= top[0] * top[1];
                    cnt += top[1];
                }
                curr += h * cnt;
                stack.push(new int[]{h, cnt});
                ans += curr;
            }
        }

        return ans;
    }
}
