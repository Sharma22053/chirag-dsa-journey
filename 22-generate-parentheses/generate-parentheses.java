class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        backtrack(list,0,0,"",n);
        return list;
    }
    void backtrack(ArrayList<String> list, int open, int close, String curr, int max){
        if(curr.length() == max * 2){
            list.add(curr);
            return;
        }

        if(open < max){
            backtrack(list,open+1,close,curr+"(",max);
        }
        if(close < open){
            backtrack(list,open,close+1,curr+")",max);
        }
    }
}