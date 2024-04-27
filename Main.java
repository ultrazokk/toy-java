public class Main {
    public static void main(String[] args) {
        ToyRaffle raffle = new ToyRaffle();
        raffle.addToy(new Toy("1", "Слоник", 10));
        raffle.addToy(new Toy("2", "Мишка", 20));
        raffle.addToy(new Toy("3", "Кролик", 30));

        raffle.drawAndSave(10, "raffle_results.txt");
    }
}

