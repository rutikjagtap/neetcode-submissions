class Solution {
    public int characterReplacement(String s, int k) {
        int maxfrq = 0;
        int maxLen = 0;
        int left = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxfrq = Math.max(maxfrq,map.get(ch));

            while((right - left +1) - maxfrq > k){
                char ch1 = s.charAt(left);
                map.put(ch1,map.get(ch1)-1);
                if(map.get(ch1) == 0){
                    map.remove(ch1);
                }
                left++;
            }
            maxLen = Math.max(maxLen,right - left +1);
        }
        return maxLen;
    }
}
