class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<String, Integer> map = new HashMap<>();
        // row check - 
        for(char[] row: board){
            for(char c: row){
                if(c=='.') continue;
                String key = c+"";
                map.put(key, map.getOrDefault(key, 0)+1);
                if(map.get(key)>1) return false;
            }
            map.clear();
        }
        

        // column check - 
        for(int col=0; col<9; col++){
            for(int row=0; row<9; row++){
                char c = board[row][col];
                if(c=='.')continue;
                String key = c+"";
                map.put(key, map.getOrDefault(key, 0)+1);
                if(map.get(key)>1) return false;
            }
            map.clear();
        }
        

        // check each box - 
        for(int box=0; box<9; box++){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    int row = (box/3)*3 + i;
                    int col = (box%3)*3 + j;
                    if(board[row][col]=='.') continue;
                    String key = board[row][col]+"";
                    map.put(key, map.getOrDefault(key, 0)+1);
                    if(map.get(key)>1) return false;
                }
            }
            map.clear();
        }
        return true;

    }
}
