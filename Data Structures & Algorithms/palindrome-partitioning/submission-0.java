class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(s, 0, res, path);
        return res;
    }
    public void backtrack(String s, int start, List<List<String>> res, List<String> path){
        if(start == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int end = start; end< s.length(); end++){
            if(!isPalindrome(s, start, end)){
                continue;
            }
            path.add(s.substring(start, end+1));
            backtrack(s, end+1, res, path);
            path.remove(path.size() - 1);
        }
    }
    public boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
