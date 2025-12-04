class Solution {
public:
    int countCollisions(string directions) {
        int n = directions.size();
        if (n <= 1)
            return 0;
        int i = 0, j = n - 1;
        while (i < n && directions[i] == 'L')
            i++;
        while (j >= 0 && directions[j] == 'R')
            j--;
        int count = 0;
        for (int k = i; k <= j; k++) {
            if (directions[k] != 'S')
                count++;
        }
        return count;
    }
};