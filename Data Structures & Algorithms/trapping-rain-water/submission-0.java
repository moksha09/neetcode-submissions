class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int totalArea = 0;
        
        for(int i=0; i<n; i++){
            int leftHeight = 0;
            for(int l=0; l<i; l++){
                leftHeight = Math.max(height[l], leftHeight);
            }
            if(leftHeight==0 || leftHeight<=height[i]) continue;

            int rightHeight = 0;
            for(int r=i+1; r<n; r++){
                rightHeight = Math.max(height[r], rightHeight);
            }
            if(rightHeight==0 || rightHeight<=height[i]) continue;

            int area = Math.min(leftHeight, rightHeight) - height[i];
            totalArea += area;
        }
        return totalArea;
    }
}
