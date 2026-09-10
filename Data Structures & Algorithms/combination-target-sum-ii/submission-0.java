class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(candidates, 0, target, res, path);
        return res;        
    }
    public void backtrack (int [] candidates, int start, int target, 
        List<List<Integer>> res, List<Integer> path){

            if(target == 0){
                res.add(new ArrayList<>(path));
                return;
            }
            if(target < 0){
                return;
            }
            for(int i=start;i<candidates.length;i++){
                if(i>start && candidates[i] == candidates[i - 1]){
                    continue;
                }
                path.add(candidates[i]);
                backtrack(candidates,i+1, target - candidates[i], res,path);
                path.remove(path.size() - 1);

            }
    }
}
