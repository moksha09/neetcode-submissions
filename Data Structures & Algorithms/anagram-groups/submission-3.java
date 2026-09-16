class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            int[] charKey = new int[26];
            for(char ch : str.toCharArray()){
                charKey[ch - 'a'] += 1;
            }
            String key = Arrays.toString(charKey);
            List<String> value = map.getOrDefault(key, new ArrayList<String>());
            value.add(str);
            map.put(key, value);
        }

        List<List<String>> result = new ArrayList<>();
        for(List<String> value : map.values()){
            result.add(value);
        }
        return result;
    }
}
