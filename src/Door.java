public class Door extends Cell{
    @Override
    public String toString() {
        return "Door";
    }

    @Override
    public void quest(Board board) {
        System.out.println("Поздравляю, вы победили!!!");
        System.exit(0);
    }
}
