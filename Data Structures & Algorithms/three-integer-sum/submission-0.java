class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // lets try brute force - 
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int start = i+1;
            int end = n-1;
            while(start<end){
                int sum = nums[start] +nums[end];
                if(sum == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    start++;
                    end--;
                    while(start<end && nums[start] == nums[start-1]){
                        start++;
                    }
                }else if(sum < target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        // remove the duplicates - 

        return result;
    }


}
