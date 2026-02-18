func hasAlternatingBits(n int) bool {
    current := n % 2
    n /= 2
    for(n > 0){
        if current == n % 2 {
            return false
        }
        current = n % 2
        n /= 2
    }
    return true
}