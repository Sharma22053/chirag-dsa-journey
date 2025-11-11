class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<Pair> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        char[] arr = {'A','C','G','T'};
        for(String str : bank){
            set.add(str);
        }
        if(!set.contains(endGene)) return -1;
        queue.offer(new Pair(startGene,0));
        while(!queue.isEmpty()){
            Pair current = queue.poll();
            String currentWord = current.word;
            int currentLevel = current.level;
            if(currentWord.equals(endGene)) return currentLevel;
            for(int i=0;i<currentWord.length();i++){
                for(int ch =0;ch<arr.length;ch++){
                    char[] replaced = currentWord.toCharArray();
                    replaced[i] = arr[ch];
                    String replacedWord = new String(replaced);
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        queue.offer(new Pair(replacedWord,currentLevel + 1));
                    }
                }
            }
        }
        return -1;
    }
}
class Pair{
    String word;
    int level;
    Pair(String word,int level){
        this.word = word;
        this.level = level;
    }
}