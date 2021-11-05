public class Game {

    // Declare objects of classes Board and Player
    private Board board;
    private Player player1;
    private Player player2;
    // Create a currentPlayer object to allow players to take turn without any if/else statements or code redundancy
    private Player currentPlayer;

    // Game constructor instantiating our objects
    public Game(){
    board = new Board();
    player1 = new Human('r');
    player2 = new Computer('y');
    currentPlayer = player1;

    /* playGame() is set to private and therefore won't be accessed by the Main class,
    unless called in the constructor which is public
    */
    playGame();
    }

    private void playGame() {

        // Print out game instructions
        setupGame();

        // Print out initial board
        board.printBoard();

        /* Initialize a variable that turns the number of turns.
        Purpose is to check when board is full and that there are no winners, to declare a draw.
        */
        int turnCount = 0;

        // Until we have a winner...
        while (!board.hasWon(currentPlayer)) {
            // ... and while we haven't reached 42 turns...
            while (turnCount < 42) {
                try {
                    // ... take input from the current player...
                    int userInput = currentPlayer.getPosition();
                    if (board.isColumnFull(userInput)) {
                        boolean columnFull = true;
                        while (columnFull) {
                            if(currentPlayer.isHuman()) {
                                System.out.println("Column " + userInput + " is full. Please enter a valid column.");
                            }
                            columnFull = false;
                            swapPlayer();
                            turnCount--;
                        }

                    } else {
                        // ... prints out the selected column for reference...
                        System.out.println(currentPlayer.getName() + " chose column " + userInput);
                        // ... place the counter of the relevant color in the column...
                        board.placeCounter(currentPlayer.isHuman(), userInput);
                        // ... and print the board.
                        board.printBoard();
                        System.out.println("");
                    }

                    // Prints out a message and exit game in case of a draw (i.e. if there has been 42 turns with no winner)
                    if (turnCount >= 41) {
                        System.out.println("No one has won. Game is over");
                        System.exit(0);
                    }

                    // Prints out a message and exit game in case last player is the winner
                    if (board.hasWon(currentPlayer)) {
                        System.out.println(currentPlayer.getName() + " has won!!!");
                        System.exit(0);
                    } else {
                        // If we have no draw or no winner, then the game can continue by swapping players
                        swapPlayer();
                        turnCount += 1;
                    }
                    // Out of range exceptions if the number entered is not between 1 and 7
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("The column entered is invalid. Please enter a number between 1 and 7");
                    // NumberFormatException if the input is not a number
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 7");
                }
            }
        }
    }

    // This method allows to swapPlayer if there is no winner or no draw after the current player's turn
    private void swapPlayer() {
        if (currentPlayer.equals(player1)){
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    // This method prints out the game instructions at the start of the game
    private String setupGame() {
        System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players red and yellow");
        System.out.println(player1.getName() + " is Red, " + player2.getName() + " is Yellow");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println("");
        return "";
    }
}