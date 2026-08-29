class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;
        for(int i=0;i<piles.length;i++){
            end = Math.max(end,piles[i]);
        }
        while(start < end){
            int total =0;
            int mid = start + (end - start)/2;
            
            for(int i=0;i<piles.length;i++){
                total+=(piles[i] + mid - 1) / mid;
            }
            if(total <= h){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}
