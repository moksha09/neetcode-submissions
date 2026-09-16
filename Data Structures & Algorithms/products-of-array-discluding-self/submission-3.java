class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        // if(n==0) return result;

        int[] prefix = new int[n];
        prefix[0] = 1;
        int[] suffix = new int[n];
        suffix[n-1] = 1;

        // fill the prefix array (left-right)
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        // fill the suffix array (right-left)
        for(int i=n-2; i>=0; i--){
            suffix[i] = suffix[i+1]*nums[i+1];
        }

        // fill the result - 
        for(int i=0; i<n; i++){
            result[i] = prefix[i]*suffix[i];
        }
        return result;
    }

    
}  
