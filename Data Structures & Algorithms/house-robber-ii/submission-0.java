class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int dp1[] = new int [n];
        Arrays.fill(dp1,-1);
        int case1 = solve(nums,0,n-2,dp1);

        int []dp2 = new int [n];
        Arrays.fill(dp2,-1);
        int case2 = solve(nums,1,n-1,dp2);

        return Math.max(case1,case2);
    }
    public int solve(int [] nums, int index, int end, int [] dp){
        if(index > end){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int rob = nums[index] + solve(nums,index+2, end,dp);
        int skip = solve(nums, index+1,end, dp);

        dp[index] = Math.max(rob, skip);
        return dp[index];
    }
}
