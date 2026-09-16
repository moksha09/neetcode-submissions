class Solution {

    public String encode(List<String> strs) {
        String delimiter = "#";
        StringBuilder encodedString = new StringBuilder();
        for(String s : strs){
            int length = s.length();
            encodedString.append(length).append(delimiter).append(s);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        helper(str, 0, str.length(), result);
        return result;

    }

    public void helper(String str, int start, int end, List result){
        if(start>=end){
            return;
        }
        int delimiterIndex = -1;
        for(int i=start; i<end; i++){
            if(str.charAt(i)=='#'){
                delimiterIndex = i;
                break;
            }
        }
        if(delimiterIndex==-1) return;
        int length = Integer.parseInt(str.substring(start, delimiterIndex));
        result.add(str.substring(delimiterIndex+1, delimiterIndex+length+1));
        helper(str, delimiterIndex+length+1, end, result);
    }

    
}
