class Solution {
    public List<String> letterCombinations(String digits) {
         if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        HashMap<Character,String> digitToLetters = new HashMap<>();
        digitToLetters.put('2',"abc");
        digitToLetters.put('3',"def");
        digitToLetters.put('4',"ghi");
        digitToLetters.put('5',"jkl");
        digitToLetters.put('6',"mno");
        digitToLetters.put('7',"pqrs");
        digitToLetters.put('8',"tuv");
        digitToLetters.put('9',"wxyz");
        int n = digits.length();
        ArrayList<String> res = new ArrayList<>();
        solve(digits, n, 0, new StringBuilder(), res, digitToLetters);
        return res;
    }
    public void solve(String digits, int n, int index, StringBuilder diary, ArrayList<String> res, HashMap<Character, String> digitToLetters){
        if(index == n){
            res.add(diary.toString());
            return;
        }
        char digit = digits.charAt(index);
        String choice = digitToLetters.get(digit);
        for(int j=0; j<choice.length();j++){
            diary.append(choice.charAt(j));
            solve(digits, n, index+1, diary, res, digitToLetters);
            diary.deleteCharAt(diary.length()-1);
        }
    }
}
