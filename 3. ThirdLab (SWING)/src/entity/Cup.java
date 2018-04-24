package entity;
/**
 * <h1>Cup</h1>
 *
 * Cup class represents the coffee,
 * that the student is handling.
 */
public class Cup extends Thing {
    private int capacity;
    protected Content content;

    public Cup(int capacity, Content content, int weight)
            throws IllegalArgumentException{
        super(weight);
        if(capacity <= 0) {
            throw new IllegalArgumentException("The value of capacity param can not be zero or negative!");
        }
        if(content == null) {
            throw new IllegalArgumentException("The value of content param can not be null!");
        }
        this.capacity = capacity;
        this.content = content;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public Content getContent() {
        return this.content;
    }

    public void fill(Content content) {
        this.content = content;
    }
}