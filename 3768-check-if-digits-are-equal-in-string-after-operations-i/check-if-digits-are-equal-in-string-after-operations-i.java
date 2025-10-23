class Solution {
    public boolean hasSameDigits(String s) {
        char[] arr = s.toCharArray();

        int n = s.length();
        for (int i = arr.length - 1; i >= 2; i--) {
            for (int j = 0; j < i; j++) {
                arr[j] = (char) ((arr[j] + arr[j + 1]) % 10 + '0');
            }
        }
        return arr[0] == arr[1];
    }

}