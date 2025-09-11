class Solution {
    public String sortVowels(String s) {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(isVowel(c)){
                pq.add(c);
            }
        }

        for(char ch : s.toCharArray()){
            if(isVowel(ch)){
                sb.append(pq.poll());
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();


    }

    private boolean isVowel(char ch){
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}