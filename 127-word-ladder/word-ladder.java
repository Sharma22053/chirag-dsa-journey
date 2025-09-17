class Pair{
    String word;
    int level;

    Pair(String word,int level){
        this.word = word;
        this.level = level;
    }
}

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord,1));

        Set<String> set = new HashSet<>();
        
        for(String s : wordList){
            set.add(s);
        }
        set.remove(beginWord);

        while(!queue.isEmpty()){
            Pair first = queue.poll();
            String word = first.word;
            int level = first.level;

            if(word.equals(endWord)) return level;

            for(int i=0;i<word.length();i++){
                for(char ch = 'a';ch<='z';ch++){
                    char replaced[] = word.toCharArray();
                    replaced[i] = ch;
                    String replacedWord = new String(replaced);

                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        queue.add(new Pair(replacedWord,level+1));
                    }
                }
            }

        }

        return 0;

    }
}