class Solution {
    public int longestConsecutive(int[] nums) {
        int lengthMax = 0;
        // sort the array - 
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            int length = 1;
            int current = nums[i];
            for(int j=i+1; j<nums.length; j++){
                if(nums[j] == current + 1){
                    current = nums[j];
                    length++;
                }else if(nums[j] == current){
                    continue;
                }else{
                    break;
                }
            }
            lengthMax = Math.max(lengthMax, length);
        }

        return lengthMax;
    }
}
