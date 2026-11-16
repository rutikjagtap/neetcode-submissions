class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int i=0;i<piles.length;i++){
            high = Math.max(high,piles[i]);
        }
        while(low <= high){
            int mid = low + (high - low)/2;
            if(ispossible(piles,h,mid)){
                high = mid-1;
            }
            else{
                low = mid +1;
            }
        }
        return low;
    }
    public boolean ispossible(int[] piles,int h,int mid){
        long totalhours = 0;
        for(int x : piles){
            totalhours += ((long)x + mid -1)/mid;
        }
        return h>= totalhours;
    }
}
