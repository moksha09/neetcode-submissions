class Solution {
    public int maxArea(int[] heights) {
        // brute force - 
        int maxArea = 0;
        int n = heights.length;

        for(int i=0; i<n; i++){
            int area = 0;
            for(int j=i+1; j<n; j++){
                int height = Math.min(heights[i], heights[j]);
                int width = j-i;
                area = Math.max(area, height*width);
            }
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
        
    }
}
