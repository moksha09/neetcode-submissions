class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int area = 0;

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int index = stack.pop();
                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();

                area = Math.max(area, (right-left-1)*heights[index]);
            }
            stack.push(i);
        }
        //empty the stack - 
        while(!stack.isEmpty()){
            int index = stack.pop();
            int right = n;
            int left = stack.isEmpty() ? -1 : stack.peek();

            area = Math.max(area, (right-left-1)*heights[index]);
        }

        return area;
        
    }
}
