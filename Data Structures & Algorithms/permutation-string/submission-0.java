class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = 0;
        int r = 0;
        int k = s1.length();
        if(k>s2.length()) return false;
        int[] f1 = new int[26];
        int[] f2 = new int[26];

        // fill the freq of s1 - 
        for(char c : s1.toCharArray()){
            f1[c-'a'] += 1;
        }

        // fill the freq of first window in s2 - 
        for(int i=0; i<k; i++){
            f2[s2.charAt(i)-'a'] +=1;
        }

        if(Arrays.equals(f1, f2)) return true;

        for(int i=1; i<=s2.length()-k; i++){
            f2[s2.charAt(i-1)-'a']--;
            f2[s2.charAt(i+k-1)-'a']++;
            if(Arrays.equals(f1, f2)) return true;
        }
        return false;

    }
}
