class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // fill the heap fo rthe first window - 
        for(int i=0; i<k; i++){
            maxHeap.add(nums[i]);
        }
        result[0] = maxHeap.peek();

        for(int right=k; right<n; right++){
            maxHeap.remove(nums[right-k]);
            maxHeap.add(nums[right]);
            result[right-k+1] = maxHeap.peek();
        }
        return result;
        
    }
}
