class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == endWord) return 0;
        Queue<Pair> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(String str : wordList){
            set.add(str);
        }
        queue.offer(new Pair(beginWord,1));
        while(!queue.isEmpty()){
            Pair current = queue.poll();
            String currentWord = current.word;
            int distance = current.distance;
            if(currentWord.equals(endWord)) return distance;
            for(int i=0;i<currentWord.length();i++){
                for(char ch = 'a';ch<='z';ch++){
                    char[] replaced = currentWord.toCharArray();
                    replaced[i] = ch;
                    String replacedWord = new String(replaced);
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        queue.offer(new Pair(replacedWord,distance+1));
                    }

                }
            }
            
        }
        return 0;
    }
}
class Pair{
    String word;
    int distance;
    Pair(String word,int distance){
        this.word = word;
        this.distance = distance;
    }
}