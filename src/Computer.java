public class Computer extends Player {

    private boolean isHuman;
    private String name;

    public Computer(char counter) {
        super(counter);
        this.isHuman = false;
        this.name = "Computer";
    }

    // Generate random number for computer input
    public int getPosition(){
        int col = 0;
        double rand;
        try{
            rand = Math.random()*((7 - 1) +1);
            col = (int) rand;
        }
        catch(Exception e){

        } return col + 1;
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
