class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for(int i=0; i<strs.length; i++){
            if(strs[i] == null) continue;
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            for(int j=i+1; j<strs.length; j++){
                if(strs[j] == null) continue;
                if(isAnagram(strs[i], strs[j])){
                    list.add(strs[j]);
                    strs[j] = null;
                }
            }
            result.add(list);
        }
        return result;
    }

    public boolean isAnagram(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        char[] c = new char[26];
        for(int i=0; i<a.length(); i++){
            c[a.charAt(i) - 'a'] += 1;
            c[b.charAt(i) - 'a'] -= 1;
        }
        for(int i=0; i<c.length; i++){
            if(c[i]!=0) return false;
        }
        return true;
    }
}
