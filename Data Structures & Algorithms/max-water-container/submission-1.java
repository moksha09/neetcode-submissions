class Solution {
    public int maxArea(int[] heights) {
        // brute force - 
        int maxArea = 0;
        int n = heights.length;
        int start = 0;
        int end = n-1;

        while(start<end){
            int currentArea = Math.min(heights[start], heights[end])*(end-start);
            maxArea = Math.max(currentArea, maxArea);

            if(heights[start] <= heights[end]){
                start++;
            }else{
                end--;
            }
        }

        return maxArea;
        
    }
}
