class Solution {
     
    public int maximumGain(String s, int x, int y) {
        StringBuilder sb = new StringBuilder();
        int countAB = 0;
        int countBA = 0;
        if(x>y){
           for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == 'b' && sb.length() > 0 && sb.charAt(sb.length() -1) == 'a'){
                    sb.setLength(sb.length() - 1);
                    countAB++;
                    
                } else{
                    sb.append(s.charAt(i));
                    
                }
            }
            s = sb.toString();
            sb.setLength(0);
             for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == 'a' && sb.length() > 0 && sb.charAt(sb.length() -1) == 'b'){
                   sb.setLength(sb.length() - 1);
                    countBA++;
                    
                } else{
                    sb.append(s.charAt(i));
                    
                }
            }

    } else {  
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == 'a' && sb.length() > 0 && sb.charAt(sb.length() -1) == 'b'){
                   sb.setLength(sb.length() - 1);
                    countBA++;
                    
                } else{
                    sb.append(s.charAt(i));
                
                }
            }
            s = sb.toString();
            sb.setLength(0);
             for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == 'b' && sb.length() > 0 && sb.charAt(sb.length() -1) == 'a'){
                   sb.setLength(sb.length() - 1);
                    countAB++;
                    
                } else{
                    sb.append(s.charAt(i));
                    
                }
            }

    }
    int total = (x * countAB) + (y*countBA);
    return total; 
                
        } 
    }
