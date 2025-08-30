class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] column = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for(int i=0;i<9;i++){
            rows[i] = new HashSet<>();
            column[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c = board[i][j];
                if(c == '.') continue;

                int boxIndex = (i/3) * 3 + (j/3);
                if(rows[i].contains(c) || column[j].contains(c) || boxes[boxIndex].contains(c)){
                    return false;
                }
                rows[i].add(c);
                column[j].add(c);
                boxes[boxIndex].add(c);
            }
        }
        return true;
    }
}