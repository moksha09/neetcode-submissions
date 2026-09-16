class Solution {
    public String minWindow(String s, String t) {
        int[] f1 = new int[58];
        int[] f2 = new int[58];
        int k = t.length();
        if(k>s.length()) return "";
        String result = "";
        
        // fill the frequency for t in f1 and
        // the freq of of first window of s in f2 
        for(int i=0; i<k; i++){
            f1[t.charAt(i) - 'A'] +=1;
            f2[s.charAt(i) - 'A'] +=1;
        }

        // check if first window is valid or not - 
        if(isValid(f1, f2)) {
            result = s.substring(0,k);
            return result;
        }

        // start checking for remaining window - 
        int l = 0;
        int r = k-1;
        while(r<s.length() && l<s.length()){
            if(!isValid(f1, f2)){
                r++;
                if(r<s.length()){
                    f2[s.charAt(r)-'A']++;
                }
            }else{
                String currentResult = s.substring(l, r+1);
                if(result.length()==0 || currentResult.length()<result.length()){
                    result = currentResult;
                    if(result.length()==k) return result;
                }
                f2[s.charAt(l)-'A']--;
                l++;
            }
        }

        return result;
    }

    public boolean isValid(int[] f1, int[] f2){
        for(int i=0; i<f1.length; i++){
            if(f2[i] < f1[i]){
                return false;
            }
        }
        return true;
    }
}
