class Solution {
    public int longestConsecutive(int[] nums) {
        int lengthMax = 0;
        
        // creating hashset - 
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        for(int num : nums){
            int current = num;
            int length = 1;
            if(!set.contains(current-1)){ // check if the item is a start of a sequence
                while(set.contains(current+1)){
                    length++;
                    current++;
                }
                lengthMax = Math.max(length, lengthMax);
            } 
        }

        return lengthMax;
    }
}
