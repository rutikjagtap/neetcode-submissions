class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int maxLen = 0;
        while(left < prices.length -1){
            for(int right = left +1;right<prices.length;right++){
                maxLen = Math.max(maxLen,prices[right] - prices[left]);
            }
            left++;
        }
        
        return maxLen; 

    }
}
