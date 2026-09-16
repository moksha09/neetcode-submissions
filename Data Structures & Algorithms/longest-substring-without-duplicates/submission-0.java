class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLength = 0;

        while(i<n && j<n){
            if(set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }else{
                set.add(s.charAt(j));
                maxLength = Math.max(maxLength, set.size());
                j++;
            }
        }

        return maxLength;
        
    }
}
