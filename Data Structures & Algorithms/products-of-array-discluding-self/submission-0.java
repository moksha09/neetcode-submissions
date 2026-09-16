class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int left = product(nums, 0, i);
            int right = product(nums, i+1, nums.length);
            result[i] = left*right;
        }
        return result;
    }

    public int product(int[] nums, int start, int end){
        int product = 1;
        if(start>=end) return product;
        for(int i=start; i<end; i++){
            product = product*nums[i];
        }
        return product;
    }
}  
