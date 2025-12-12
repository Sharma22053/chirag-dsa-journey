class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort((a,b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            if(timeA != timeB){
                return Integer.compare(timeA,timeB);
            }
            boolean aMessage = a.get(0).equals("MESSAGE");
            boolean bMessage = b.get(0).equals("MESSAGE");
            return Boolean.compare(aMessage,bMessage);
        });

        int[] count = new int[numberOfUsers];
        int[] nextOnlineTime = new int[numberOfUsers];

        for(List<String> event : events){
            int currentTime = Integer.parseInt(event.get(1));
            String type = event.get(0);

            if(type.equals("MESSAGE")){
                String target = event.get(2);
                if(target.equals("ALL")){
                    for(int i=0;i<numberOfUsers;i++){
                        count[i]++;
                    }
                }else if(target.equals("HERE")){
                    for(int i=0;i<numberOfUsers;i++){
                        if(nextOnlineTime[i] <= currentTime){
                            count[i]++;
                        }
                    }
                }else {
                    String[] users = target.split(" ");
                    for(String user : users){
                        int index = Integer.parseInt(user.substring(2));
                        count[index]++;
                    }
                }

            } else {
               int index = Integer.parseInt(event.get(2));
               nextOnlineTime[index] = currentTime + 60;
            }
        }
        return count;
    }
}