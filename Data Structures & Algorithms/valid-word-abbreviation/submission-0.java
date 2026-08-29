class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while (i < word.length() && j < abbr.length()) {
            char ac = abbr.charAt(j);
            if (Character.isDigit(ac)) {
                if (ac == '0') {
                    return false; // leading zero not allowed
                }
                int curr = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    curr = curr * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += curr;
            } else {
                if (word.charAt(i) != ac) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}