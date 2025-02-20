public class Board{
    public char[] board;
    public static int winningMoves[][] = {
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // vertikal
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // horizontal
        {0, 4, 8}, {2, 4, 6} // diagonal
    };

    public Board(){
        board = new char[]{
            '_', '_', '_',
            '_', '_', '_',
            '_', '_', '_'
        };
    }

    public void printBoard(){
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(board[i*3+j] + " ");
            }
            System.out.println();
        }
    }

    public boolean placeMove(int x, int y, char symbol){
        int index = y*3+x;
        if (x < 0 || x > 2 || y < 0 || y > 2 || board[index] != '_'){
            return false;
        }
        board[index] = symbol;
        return true;
    }

    public boolean checkWin(char symbol){
        for(int[] move : winningMoves) {
            if(board[move[0]] == symbol && board[move[1]] == symbol && board[move[2]] == symbol){
                return true;
            }
        }
        return false;
    }

    public boolean isTie(){
        for(char cell : board){
            if(cell == '_'){
                return false;
            }
        }
        return true;
    }
}