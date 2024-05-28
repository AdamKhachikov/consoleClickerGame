import java.util.ArrayList;
import java.util.Random;

public class Board {
    Cell[][] board;
    Board(int width){
        board = new Cell[width][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = new EmptyCell();
            }
        }
        Random random = new Random();
        int rand = random.nextInt(0, 4);
        int rand2 = random.nextInt(0, 4);
        for (int i = 0; i < 10; i++){
            board[rand2][rand] = new BigMonster();
            rand = random.nextInt(0, 4);
            rand2 = random.nextInt(0, 4);
            board[rand2][rand] = new SmallMonster();
            rand = random.nextInt(0, 4);
            rand2 = random.nextInt(0, 4);
        }
        board[0][rand] = new Door();
        board[4][rand2] = new Person();

    }
    public String generateFence() {
        String fence = "";
        fence += "+";
        String segment = "----+";
        fence += segment.repeat(board.length);
        return fence;
    }
    @Override
    public String toString() {
        StringBuilder boardStr = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            boardStr.append(this.generateFence());
            boardStr.append("\n|");
            for (int j = 0; j < board[i].length; j++) {
                boardStr.append(STR."\{board[i][j].toString()}|");
            }
            boardStr.append("\n");
        }
        boardStr.append(this.generateFence());
        return boardStr.toString();
    }
}
