class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int left = 0;
        int right = 0;
        int result = 0;
        int mostFreq = 0;

        while(right<s.length()){
            char c = s.charAt(right);
            count.put(c, count.getOrDefault(c,0)+1);

            mostFreq = Math.max(mostFreq, count.get(c));
            int windowLength = right-left+1;
            
            // check is the window is valid or not- 
            if(windowLength - mostFreq > k){
                count.put(s.charAt(left), count.get(s.charAt(left))-1);
                left++;
            }else{
                result = Math.max(result, windowLength);
            }
            right++;
        }
        return result;
    }
}
