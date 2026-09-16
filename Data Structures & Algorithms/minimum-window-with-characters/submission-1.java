class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        int[] need = new int[128]; // t freq
        int[] window = new int[128]; // s window freq
        
        String result = "";
        
        // fill the frequency for t in need
        for(char c : t.toCharArray()){
            need[c]++;
        }

        int matched = 0;
        int l = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for(int r = 0; r<s.length(); r++){
            char c = s.charAt(r);
            window[c]++;

            // check if this char contributes towards satisfying t - 
            if(window[c] <= need[c]){
                matched++;
            }

            while(matched == t.length()){ // window is valid
                int windowLength = r-l+1;

                if(windowLength < minLength){
                    minLength = windowLength;
                    start = l;
                }

                char leftChar = s.charAt(l);
                window[leftChar]--;

                // window becomes invalid - 
                if(window[leftChar] < need[leftChar]){
                    matched--;
                }

                l++;
            }
        }

        return minLength == Integer.MAX_VALUE?"":s.substring(start, start+minLength);
    }


}
