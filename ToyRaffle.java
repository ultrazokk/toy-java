import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;


public class ToyRaffle {
    private PriorityQueue<Toy> toys;
    private Random random;

    public ToyRaffle() {
        this.toys = new PriorityQueue<>(Comparator.comparingInt(Toy::getWeight))
        this.random = new Random();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }    

    public Toy draw() {
        Toy toy = toys.poll();
        if (toy != null) {
            toys.add(toy);
        }
        return toy;
    }
    
}
