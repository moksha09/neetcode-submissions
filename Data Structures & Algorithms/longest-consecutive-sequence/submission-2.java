class Solution {
    public int longestConsecutive(int[] nums) {
        int lengthMax = 0;
        
        // creating hashset - 
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        for(int num : nums){
            // check if the item is a start of a sequence - 
            if(!set.contains(num-1)){
                int length = 1;
                while(set.contains(num+length)){
                    length++;
                }
                lengthMax = Math.max(length, lengthMax);
            } 
        }

        return lengthMax;
    }

    
}
