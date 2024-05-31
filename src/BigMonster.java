import java.util.Random;
import java.util.TimerTask;

public class BigMonster extends Monster {
    @Override
    public String toString() {
        return " Bm ";
    }

    public void quest(Board board) {
                Random random = new Random();
                int rand = random.nextInt(5, 30);
                int rand2 = random.nextInt(5, 10);
                System.out.println(rand2 + " * " + rand + " = ");
                int answer = sc.nextInt();
                if (answer == rand2 * rand) {
                    System.out.println("Вы прошли задание монстра");
                } else {
                    board.lives -= 2;
                    board.lives = Math.max(board.lives, 0);
                    System.out.println("Вы не справились( у вас осталось " + board.lives + " HP");
                }
                if (board.lives <= 0) {
                    System.out.println("Вы проиграли");
                    System.exit(0);
                }
            }
        }
