class Solution {
    public int longestConsecutive(int[] nums) {
        int lengthMax = 0;
        
        // creating hashset - 
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        for(int i=0; i<nums.length; i++){
            int length = 1;
            int current = nums[i];
            for(int j=0; j<set.size()-1; j++){
                if(set.contains(current+1)){
                    length++;
                    current += 1;
                }
            }
            lengthMax = Math.max(lengthMax, length);
        }

        return lengthMax;
    }
}
