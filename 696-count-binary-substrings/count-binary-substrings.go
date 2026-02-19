func countBinarySubstrings(s string) int {
    if len(s) == 0{
        return 0
    }
    ans , prev , current := 0,0,1
    for i:= 1 ; i< len(s);i++{
        if s[i-1] != s[i]{
            if prev < current {
                ans += prev
            } else {
                ans += current 
            }
            prev = current 
            current = 1
        } else {
            current++
        }
    }
    
if prev < current {
        ans += prev
    } else {
        ans += current
    }
    return ans

}