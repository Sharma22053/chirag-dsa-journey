class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Coupon> result = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList("electronics", "grocery", "pharmacy", "restaurant"));
        Map<String, Integer> priority = new HashMap<>();
        priority.put("electronics", 0);
        priority.put("grocery", 1);
        priority.put("pharmacy", 2);
        priority.put("restaurant", 3);

        for (int i = 0; i < code.length; i++) {
            if(code[i]!= null && code[i].matches("^[A-Za-z0-9_]+$")
            && set.contains(businessLine[i]) && isActive[i]){
                result.add(new Coupon(code[i], businessLine[i]));
            }
        }
        result.sort(
            (a,b) -> {
              int cmp =  Integer.compare(
                    priority.get(a.businessLine),
                    priority.get(b.businessLine)
                );
                if(cmp != 0) return cmp;
                return a.code.compareTo(b.code);
            }
        );
        List<String> valid = new ArrayList<>();
        for (Coupon c : result) {
            valid.add(c.code);
        }

        return valid;
    }
}
class Coupon{
    String code;
    String businessLine;
    Coupon(String code,String businessLine){
        this.code = code;
        this.businessLine = businessLine;
    }
}