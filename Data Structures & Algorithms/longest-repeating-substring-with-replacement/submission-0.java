class Solution {
    public int characterReplacement(String s, int k) {
        int low = 0;
        int high = 0;
        int res = 0;
        int maxFreq = 0;
        HashMap<Character,Integer> freq = new HashMap<>();
        for(high =0;high<s.length();high++){
            char ch = s.charAt(high);
            freq.put(ch,freq.getOrDefault(ch, 0)+1);
            maxFreq = Math.max(maxFreq, freq.get(ch));
            while((high - low + 1) - maxFreq > k){
                char left = s.charAt(low);
                freq.put(left,freq.get(left)-1);
                low++;
            }
            res = Math.max(res,high - low + 1);
        }
        return res;
    }
}
