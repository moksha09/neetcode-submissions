class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while(start<end){
            int diff = target - numbers[start];
            if(numbers[end] == diff){
                return new int[] {start+1, end+1};
            }
            else if(numbers[end] < diff){
                start++;
            }else{
                end--;
            }
        }
        return new int[] {-1, -1};
    }
    
}
