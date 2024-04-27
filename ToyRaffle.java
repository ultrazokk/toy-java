import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class ToyRaffle {
    private PriorityQueue<Toy> toys;
    private Random random;

    public ToyRaffle() {
        this.toys = new PriorityQueue<>(Comparator.comparingInt(Toy::getWeight));
        this.random = new Random();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public Toy draw() {
        Toy toy = null;
        int randomIndex = random.nextInt(toys.size());
        for (Toy t : toys) {
            randomIndex--;
            if (randomIndex == 0) {
                toy = t;
                break;
            }
        }
        if (toy != null) {
            toys.remove(toy);
        }
        return toy;
    }

    public void drawAndSave(int times, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (int i = 0; i < times; i++) {
                Toy drawnToy = draw();
                if (drawnToy != null) {
                    writer.write(drawnToy.getId() + " - " + drawnToy.getName() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
