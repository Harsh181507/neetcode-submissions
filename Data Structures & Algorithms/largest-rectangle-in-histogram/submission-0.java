class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxHeight = 0;
        for(int i=0;i<=n;i++){
            int currHeight;
            if(i==n){
                currHeight = 0;
            }else{
                currHeight = heights[i];
            }
            while(!st.isEmpty() && currHeight < heights[st.peek()]){
                int height = heights[st.pop()];
                int w;
                if(st.isEmpty()){
                    w = i;
                }else{
                    w = i - st.peek() - 1;
                }
                maxHeight = Math.max(height*w, maxHeight);
            }
            st.push(i);
        }
        return maxHeight;
    }
}
