class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        solve(n, 0, 0, path, res);
        return res;
    }
    public void solve(int n, int open, int close, StringBuilder path, List<String> res) {
        if(open == n && close == n){
            res.add(path.toString());
            return;
        }
        if(open < n){
            path.append('(');
            solve(n,open + 1, close, path, res);
            path.deleteCharAt(path.length() - 1);
        }
        if(close < open){
            path.append(')');
            solve(n, open, close+1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
