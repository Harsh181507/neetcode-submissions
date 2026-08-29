class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.size();i++){
            String str = strs.get(i);

            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int i = 0;

        while(i < str.length()) {

            int j = i;

            // Find '#'
            while(str.charAt(j) != '#') {
                j++;
            }

            // Get length
            int len = Integer.parseInt(str.substring(i, j));

            // Start of actual string
            int start = j + 1;

            // Extract string
            String strr = str.substring(start, start + len);

            result.add(strr);

            // Move to next encoded string
            i = start + len;
        }

        return result;
    }
}
