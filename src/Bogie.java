/**
 * UC7: Bogie class to represent a train bogie with name and capacity
 * This class models a real-world train bogie with operational attributes
 */
public class Bogie {
    private String name;
    private int capacity;

    /**
     * Constructor to initialize a Bogie with name and capacity
     * @param name The name/type of the bogie
     * @param capacity The seating or load capacity
     */
    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    /**
     * Getter for bogie name
     * @return The name of the bogie
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for bogie name
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for bogie capacity
     * @return The capacity of the bogie
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Setter for bogie capacity
     * @param capacity The capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * toString method to display bogie information
     * @return String representation of the bogie
     */
    @Override
    public String toString() {
        return name + " -> " + capacity;
    }
}