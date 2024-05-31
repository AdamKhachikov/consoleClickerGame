import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Board board = new Board(5);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(board);
            char direction = scanner.next().charAt(0);
            board.step(direction);
        }


    }
}