public class Board {

    // Declare fields for our Board class

    private char[][] board;     // 2D array for our board
    private int rows;
    private int cols;
    private boolean hasWon; // variable changing winner status
    private boolean check; // variable checking winning combinations

    public Board() {
        rows = 6;
        cols = 7;
        board = new char[rows][cols];
        hasWon = false;
        check = false;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'r') {
                    System.out.print("| r ");
                } else if (board[i][j] == 'y') {
                    System.out.print("| y ");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }


    public void placeCounter(boolean isHuman, int position) {

        /* Iterates through the rows of our board to place counter
        in the first empty cell of the selected column */
        boolean placed = false;
        for (int i = board.length - 1; i >= 0; i--) {
            if (!placed) {
                if (board[i][position - 1] != 'y' && board[i][position - 1] != 'r') {
                    if (isHuman == true) {
                        board[i][position - 1] = 'r';
                    } else {
                        board[i][position - 1] = 'y';
                    }
                    placed = true;
                }
            }
        }
    }

    public boolean hasWon(Player player) {
        if (checkHorizontal(player) || checkVertical(player) || checkAscDiagonal(player) || checkDescDiagonal(player)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkHorizontal(Player player) {
        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == player.getCounter()) {
                    count++;
                    if (count >= 4) {
                        check = true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return check;
    }

    private boolean checkVertical(Player player) {
        for (int i = 0; i < board[0].length; i++) {
            int count = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == player.getCounter()) {
                    count++;
                    if (count >= 4) {
                        check = true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return check;
    }

    private boolean checkAscDiagonal(Player player) {
        for (int i=board.length-1; i>board.length-4; i--){ // Ascending diagonals can't exist if top left counter is placed further than column 4
            for (int j = 0; j < board[1].length-3; j++){ // Ascending diagonals can't exist if bottom right counter is placed higher than row 3
                int count = 0;
                for (int offset = 0; offset < 4; offset++){
                    if (board[i-offset][j+offset] == player.getCounter()){ // Check if there are four counters in a row diagonally
                        count++;
                    }
                        if (count >= 4) {
                            check = true;
                        }
                    }
                }
            }
        return check;
    }

    private boolean checkDescDiagonal(Player player) {

        for (int i=0; i<=board.length-4; i++){ // Diagonals descending left to right can't exist if bottom right counter is placed higher than row 3
            for (int j = 0; j <board[1].length-3; j++){ // Diagonals descending left to right can't exist if top left counter is placed further than column 4
                int count = 0;
                for (int offset = 0; offset < 4; offset++){
                    if (board[i+offset][j+offset] == player.getCounter()){ // Check if there are four counters in a row diagonally
                        count ++;
                    }
                    if (count >= 4) {
                        check = true;
                    }
                }
            }
        }
        return check;
    }

    public boolean isColumnFull(int position){
        if (board[0][position - 1] != '\u0000') {
            return true;
        }
        return false;
    }
}



