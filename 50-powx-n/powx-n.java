class Solution {
    
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        long exp = n;
        if(exp < 0){
            x = 1/x;
            exp = -exp;
        }
        
        return findPower(x,exp);
    }

    static double findPower(double x, long n){
        if(n == 0) return 1.0;
        double half = findPower(x,n/2);

        if( n % 2 == 0){
            return half * half;
        } 
        return x * half * half;
    }
}