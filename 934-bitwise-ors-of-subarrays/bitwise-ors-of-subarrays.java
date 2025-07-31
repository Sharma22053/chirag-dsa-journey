class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> prev = new HashSet<>();
        Set<Integer> current = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for(int i = 0;i<arr.length;i++){
            for(int x : prev){
                current.add(x | arr[i]);
                result.add( x | arr[i]);
            }
            current.add(arr[i]);
            result.add(arr[i]);

            prev = new HashSet<>(current);
            current.clear();
        }

        return result.size();
    }
}