class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> freq = new HashMap<>();
        HashMap<Character,Integer> windowFreq = new HashMap<>();
        int low =0;
        if(s1.length() > s2.length()){
            return false;
        }
        for(int i = 0;i<s1.length();i++){
            char ch = s1.charAt(i);
            freq.put(ch,freq.getOrDefault(ch, 0)+1);
        }
        for(int i=0;i<s2.length();i++){
            char ch = s2.charAt(i);
            windowFreq.put(ch,windowFreq.getOrDefault(ch,0)+1);

            if((i - low + 1) > s1.length()){
                char left = s2.charAt(low);
                windowFreq.put(left,windowFreq.get(left)-1);

                if(windowFreq.get(left) == 0){
                    windowFreq.remove(left);
                }
                low++;
            }
            if((i - low + 1) == s1.length() && windowFreq.equals(freq)){
                return true;
            }
        }
        return false;
    }
}
