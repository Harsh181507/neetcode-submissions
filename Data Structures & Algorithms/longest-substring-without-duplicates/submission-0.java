class Solution {
    public int lengthOfLongestSubstring(String s) {
        int low =0;
        int high =0;
        int res = 0;
        HashMap<Character,Integer> freq = new HashMap<>();

        for(high =0;high<s.length();high++){
            char ch = s.charAt(high);
            freq.put(ch,freq.getOrDefault(ch, 0)+1);

            while(freq.get(ch) > 1){
                char left = s.charAt(low);
                freq.put(left, freq.get(left) - 1); 

                if(freq.get(left) == 0){
                    freq.remove(left);
                }
                low++;
            }
            int len = high - low + 1;
            res = Math.max(len,res);
        }
        return res;
    }
}
