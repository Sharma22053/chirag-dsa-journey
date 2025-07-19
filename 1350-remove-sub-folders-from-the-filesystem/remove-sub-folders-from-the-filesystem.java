class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        ArrayList<String> list = new ArrayList<>();

        for (String s : folder) {
            if (list.isEmpty()) {
                list.add(s);
            } else {
                String prev = list.get(list.size() - 1);
                if (s.startsWith(prev) && s.length() > prev.length() && s.charAt(prev.length()) == '/')
                    continue;
                else {
                    list.add(s);
                }
            }

        }

        return list;
    }
}
