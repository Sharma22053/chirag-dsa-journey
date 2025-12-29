class Solution {
    Map<String,List<Character>> rules = new HashMap<>();
    Set<String> set = new HashSet<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for(String s : allowed){
            rules.computeIfAbsent(s.substring(0, 2), k -> new ArrayList<>())
                 .add(s.charAt(2));
        }
        return helper(bottom,0,new StringBuilder());
    }

    private boolean helper(String row,int index,StringBuilder next){
        if(row.length() == 1) return true;

        if(index == row.length() -1){
            String nextRow = next.toString();
            if(set.contains(nextRow)) return false;
            boolean ok = helper(nextRow,0,new StringBuilder());
            if(!ok) set.add(nextRow);
            return ok;
        }
        String key = row.substring(index,index+2);
        if(!rules.containsKey(key)) return false;

        for(char ch : rules.get(key)){
            next.append(ch);
            if(helper(row,index+1,next)) return true;
            next.deleteCharAt(next.length()-1);
        }
        return false;
    }
}