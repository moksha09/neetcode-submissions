class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            int[] c = new int[26];
            for(int j=0; j<strs[i].length(); j++){
                c[strs[i].charAt(j) - 'a'] += 1;
            }
            String key = Arrays.toString(c);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(strs[i]);
            map.put(key, value);
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> value : map.values()){
            result.add(value);
        }
        return result;
    }

}
