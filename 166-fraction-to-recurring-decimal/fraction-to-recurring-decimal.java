class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if(numerator < 0 ^ denominator <0){
            sb.append("-");
        }
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));

        sb.append(dividend/divisor);
        long remainder = dividend % divisor;
        if(remainder == 0) return sb.toString();

        sb.append(".");
        Map<Long,Integer> hmap = new HashMap<>();
        while(remainder != 0){
            if(hmap.containsKey(remainder)){
                sb.insert(hmap.get(remainder),"(");
                sb.append(")");
                break;
            }
            hmap.put(remainder,sb.length());
            remainder *= 10;
            sb.append(remainder/divisor);
            remainder %= divisor;
        }
        return sb.toString();

    }
}