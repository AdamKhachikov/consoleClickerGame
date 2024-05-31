import java.util.ArrayList;
import java.util.Random;

public class Board {
    int lives = 3;
    int doorX;
    int doorY;
    int personX;
    int personY;
    Cell[][] board;
    Board(int width){

        board = new Cell[width][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = new EmptyCell();
            }
        }
        Random random = new Random();
        int rand = random.nextInt(0, board.length);
        int rand2 = random.nextInt(0, 4);
        for (int i = 0; i < 13; i++){
            board[rand2][rand] = new BigMonster();
            rand = random.nextInt(0, board.length);
            rand2 = random.nextInt(0, board.length);
            board[rand2][rand] = new SmallMonster();
            rand = random.nextInt(0, board.length);
            rand2 = random.nextInt(0, board.length);
        }
        personX = rand;
        personY = 0;
        board[0][rand] = new Door();
        personX = board.length - 1;
        personY = rand2;
        board[board.length - 1][rand2] = new Person();

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
        for (Cell[] cells : board) {
            boardStr.append(this.generateFence());
            boardStr.append("\n|");
            for (Cell cell : cells) {
                boardStr.append(cell.toString()).append("|");
            }
            boardStr.append("\n");
        }
        boardStr.append(this.generateFence());
        return boardStr.toString();
    }
    public void step(char c){
        board[personX][personY] = new EmptyCell();
        switch (c) {
            case 'a':
                if (personY == 0){
                    break;
                }
                personY -= 1;
                break;
            case 'd':
                if(personY == board.length - 1) {
                    break;
                }
                personY += 1;
                break;
            case 'w':
                if (personX == 0) {
                    break;
                }
                personX -= 1;
                break;
            case 's':
                if (personX == board.length - 1) {
                    break;
                }
                personX += 1;
                break;
        }
        board[personX][personY].quest(this);
        board[personX][personY] = new Person();
    }
}
