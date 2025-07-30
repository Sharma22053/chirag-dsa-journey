class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        generate(result,n,new String(),0);
        return result;
    }

    static void generate(List<String> result,int n,String sb,int index){
        if(index == n){
            result.add(new String(sb));
            return;
        }

        if(index < n){
            generate(result,n,sb+"1",index+1);
             if(sb.length() == 0 || sb.charAt(sb.length() -1) != '0' ){
                        generate(result,n, sb+"0", index+1);
                }     
        }
    }
}