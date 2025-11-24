class Solution {
public:
    vector<bool> prefixesDivBy5(vector<int>& nums) {
        int prefix = 0;
        vector<bool> list;
        for(auto& n : nums){
            prefix = ((prefix << 1) + n) % 5;
            list.push_back(prefix == 0);
        }
        return list;
    }
};