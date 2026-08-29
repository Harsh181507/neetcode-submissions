class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        HashMap<Character,Integer> freq = new HashMap<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            freq.put(ch,freq.getOrDefault(ch, 0)+1);
        }
        int low =0;
        int high =0;
        int formed =0;
        int required = freq.size();
        int maxLen = Integer.MAX_VALUE;
        int start =0;
        for(high = 0;high < s.length();high++){
            char ch = s.charAt(high);
            map.put(ch,map.getOrDefault(ch, 0)+1);

            if(freq.containsKey(ch)){
                if(map.get(ch).equals(freq.get(ch))){
                    formed++;
                }
            }
            while(formed == required){
                if(high - low + 1 < maxLen){
                    maxLen = high - low + 1;
                    start = low;
                }
                char left = s.charAt(low);
                if(freq.containsKey(left)){
                    if(map.get(left).equals(freq.get(left))){
                        formed--;
                    }
                }
                map.put(left,map.get(left)- 1);
                if(map.get(left) == 0){
                    map.remove(left);
                }
                low++;
            }
        }
        if(maxLen == Integer.MAX_VALUE){
            return "";
        }else{
            return s.substring(start,start+maxLen);
        }
    }
}
