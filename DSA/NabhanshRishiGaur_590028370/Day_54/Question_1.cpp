class Solution {
public:
    int maxFrequencyElements(vector<int>& nums) {
        vector<int> freq(101, 0);
        
        int maxFreq = 0;
        int distinctAtMax = 0;
        
        for (int x : nums) {
            freq[x]++;
            int f = freq[x];
            
            if (f > maxFreq) {
                maxFreq = f;
                distinctAtMax = 1;
            } else if (f == maxFreq) {
                distinctAtMax++;
            }
        }
        
        return maxFreq * distinctAtMax;
    }
};
