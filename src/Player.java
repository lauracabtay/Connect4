// Create abstract class for Player and abstract methods that will be implemented in the Human and Computer classes
public abstract class Player {
    protected char counter;

    public Player(char counter) {
        this.counter = counter;
    }

    public abstract int getPosition();

    public abstract boolean isHuman();

    public abstract String getName();

    public abstract char getCounter();
}

