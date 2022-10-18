package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test of class Game
 * 
 * @author Rémy
 */
public class GameTest {

    public GameTest() {
    }
    
    /**
    * build a customBoard for test move
    * 
    * @return board 4*4
    */
    private int[][] CustomBoard() {
        int[][] board = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = 0;
            }
        }
        board[1][1] = 42;
        return board;
    }

    /**
     * Test of move method, of class Game.
     * 
     * move up
     */
    @Test
    public void testMoveUp() {
        System.out.println("move up");
        Direction direction = Direction.UP;
        Game instance = new Game();
        instance.setBoard(this.CustomBoard());
        instance.move(direction);
        assertEquals(instance.getBoard()[0][1], 42);
    }
    /**
     * Test of move method, of class Game. 
     * 
     * move Down
     */
    @Test
    public void testMoveDown() {
        System.out.println("move down");
        Direction direction = Direction.DOWN;
        Game instance = new Game();
        instance.setBoard(this.CustomBoard());
        instance.move(direction);
        assertEquals(instance.getBoard()[3][1], 42);
    }

    /**
     * Test of move method, of class Game. 
     * 
     * move Left
     */
    @Test
    public void testMoveLeft() {
        System.out.println("move left");
        Direction direction = Direction.LEFT;
        Game instance = new Game();
        instance.setBoard(this.CustomBoard());
        instance.move(direction);
        assertEquals(instance.getBoard()[1][0], 42);
    }

    /**
     * Test of move method, of class Game. 
     * 
     * move right
     */
    @Test
    public void testMoveRight() {
        System.out.println("move right");
        Direction direction = Direction.RIGHT;
        Game instance = new Game();
        instance.setBoard(this.CustomBoard());
        instance.move(direction);
        assertEquals(instance.getBoard()[1][3], 42);
    }
}
