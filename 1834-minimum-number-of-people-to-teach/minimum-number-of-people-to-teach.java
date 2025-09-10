class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> toTeach = new HashSet<>();
        for(int[] frnd : friendships){
            int u1 = frnd[0] - 1;
            int u2 = frnd[1] - 1;
            boolean canComm = false;

            for(int lang1 : languages[u1]){
                for(int lang2 : languages[u2]){
                    if(lang1 == lang2){
                        canComm = true;
                        break;
                    }
                }
                if(canComm) break;
            }
            if(!canComm){
                toTeach.add(u1);
                toTeach.add(u2);
            }
        }

        int min = languages.length + 1;
        for(int lang = 1;lang <= n;lang++){
            int count = 0;
            for(int user : toTeach){
                boolean knows = false;
                for(int l : languages[user]){
                    if(l== lang){
                        knows = true;
                        break;
                    }
                }
                if(!knows) count++;
            }
            min = Math.min(min,count);
        }
        return min;
    }
}