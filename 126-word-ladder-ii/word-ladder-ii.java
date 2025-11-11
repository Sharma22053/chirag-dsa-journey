class Solution {
    String b;
    Map<String, Integer> mpp = new HashMap<>();
    List<List<String>> ans = new ArrayList<>();

    private void dfs(String word, List<String> seq) {
        if (word.equals(b)) {
            List<String> temp = new ArrayList<>(seq);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }

        int steps = mpp.get(word);
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char org = arr[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                arr[i] = ch;
                String next = new String(arr);
                if (mpp.containsKey(next) && mpp.get(next) + 1 == steps) {
                    seq.add(next);
                    dfs(next, seq);
                    seq.remove(seq.size() - 1);
                }
            }
            arr[i] = org;

        }
    }

    public List<List<String>> findLadders(String st, String tar, List<String> wordList) {
        Set<String> s = new HashSet<>(wordList);
        if (st.equals(tar)) {
            List<List<String>> list = new ArrayList<>();
            list.add(Arrays.asList(st));
            return list;
        }
        if (!s.contains(tar))
            return new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(st);
        mpp.put(st, 1);
        b = st;
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int sz = queue.size();
            for (int k = 0; k < sz; k++) {
                String cur = queue.poll();
                int steps = mpp.get(cur);
                char[] arr = cur.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char org = arr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[i] = ch;
                        String next = new String(arr);
                        if (s.contains(next) && !mpp.containsKey(next)) {
                            mpp.put(next, steps + 1);
                            if (next.equals(tar))
                                found = true;
                            queue.add(next);
                        }
                    }
                    arr[i] = org;
                }
            }
        }
        if (mpp.containsKey(tar)) {
            List<String> seq = new ArrayList<>();
            seq.add(tar);
            dfs(tar, seq);
        }
        return ans;
    }
}