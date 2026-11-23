class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        int[] ans1 = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans1[i] = -1;
            }
            else{
                ans1[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>= heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = n;
            }
            else{
                ans[i] = st.peek();
            }
            st.push(i);
        }
        int maxval = 0;
        for(int i=0;i<n;i++){
            int weight = ans[i] - ans1[i] -1;
            int area = heights[i] * weight;
            maxval = Math.max(maxval,area);
        }
        return maxval;
    }
}
