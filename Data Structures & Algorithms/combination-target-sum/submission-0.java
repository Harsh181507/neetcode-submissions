class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        backtrack(nums, 0, target, result, path);
        return result;
    }
    public void backtrack(
        int[] nums, int start, int target, List<List<Integer>> result, 
        List<Integer> path) {
            if(target == 0){
                result.add(new ArrayList<>(path));
                return;
            }
            if(target < 0){
                return;
            }
            for(int i=start; i<nums.length; i++){
                path.add(nums[i]);
                backtrack(nums, i, target - nums[i], result, path);
                path.remove(path.size() - 1);
            }
        }
}
