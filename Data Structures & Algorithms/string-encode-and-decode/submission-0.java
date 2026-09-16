class Solution {

    Map<Integer, String> map = new HashMap<>();

    public String encode(List<String> strs) {
        for(int i=0; i<strs.size(); i++){
            map.put(i, strs.get(i));
        }
        return "";
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        for(int i=0; i<map.size(); i++){
            result.add(map.get(i));
        }
        return result;
    }
}
