import java.util.Scanner;

public class Human extends Player {

    private Scanner in;
    private boolean isHuman;
    private String name;

    public Human(char counter) {
        super(counter);
        this.isHuman = true;
        this.name = "Player";
        in = new Scanner(System.in);
    }

    // Get human player's input for column number
    public int getPosition() {
        int col = 0;
        String toReturn = null;
        System.out.println("Please enter a column number: ");
        toReturn = in.nextLine();
        col = Integer.parseInt(toReturn);
        return col;
    }

    public boolean isHuman(){
        return this.isHuman;
    }

    public String getName(){
        return this.name;
    }

    public char getCounter() {
        return this.counter;
    }
}

