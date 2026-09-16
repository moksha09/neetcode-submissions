class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        if(nums[start]<nums[end]) return nums[start];

        while(start<=end){
            int mid = (start+end)/2;
            if(start==mid || end==mid){
                return Math.min(nums[start], nums[end]);
            }
            if(nums[start] < nums[mid]){
                start = mid;
            }else{
                end = mid;
            }
        }

        return nums[start];
        
    }
}
