class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> queue = new LinkedList<>();
        int l = 0;
        int r = 0;

        while(r<n){
            while(!queue.isEmpty() && nums[queue.getLast()] < nums[r]){
                queue.removeLast();
            }
            queue.addLast(r);

            if(l > queue.getFirst()){
                queue.removeFirst();
            }

            if((r+1) >= k){
                result[l] = nums[queue.getFirst()];
                l++;
            }
            r++;
        }

        return result;

        
    }
}
