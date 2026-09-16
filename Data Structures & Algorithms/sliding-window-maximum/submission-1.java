class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        int max = 0;

        // calculate max for first window - 
        for(int i=0; i<k; i++){
            max = Math.max(nums[i], max);
        }
        result[0] = max;

        int left = 0;
        for(int right=k; right<n; right++){
            if(nums[left] != max){
                max = Math.max(max, nums[right]);
            }else{
                // recaclulate the max - from left+1 to right-
                max = sortAndMax(nums, left+1, right);
            }
            left++;
            result[left] = max;
        }
        return result;
        
    }

    public int sortAndMax(int[] nums, int start, int end){
        int[] copy = new int[end-start+1];
        for(int i=0; i<end-start+1; i++){
            copy[i] = nums[start+i];
        }
        Arrays.sort(copy);
        return copy[end-start];

    }
}
