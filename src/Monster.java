import java.util.Random;
import java.util.Scanner;

public abstract class Monster extends Cell{
    Scanner sc = new Scanner(System.in);
    @Override
    public void quest(Board board){
        Random random = new Random();
        int rand = random.nextInt(10, 250);
        int rand2 = random.nextInt(10, 250);
        System.out.println(rand2 + " + " + rand + " = ");
        int answer = sc.nextInt();
        if (answer == rand2 + rand){
            System.out.println("Вы прошли задание монстра");
        }
        else {
            board.lives--;
            System.out.println("Вы не справились( у вас осталось " + board.lives + " жизни");
        }
            if (board.lives == 0){
                System.out.println("Вы проиграли");
                System.exit(0);
            }
        }
    }
