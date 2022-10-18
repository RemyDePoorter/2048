package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Test of class Board
 * 
 * @author Rémy
 */
public class BoardTest {

    /**
     * Test of addTile method, of class Board.
     *
     * if It's not the same , addTile add a tile
     */
    @Test
    public void testAddTile() {
        System.out.println("addTile");
        Board instance = new Board();
        int[][] firstTab = instance.getBoard();
        instance.addTile();
        int[][] resultTab = instance.getBoard();
        boolean expResult = true;
        boolean result = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(firstTab[i][j]+" "+ resultTab[i][j]);
                if (firstTab[i][j] != resultTab[i][j]) {
                    result = true;
                }
            }
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Board.
     * 
     * in basic case
     */
    @Test
    public void testIsInside_general_true() {
        System.out.println("isInside general");
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(0, 0);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Board. 
     * 
     * in negative row case
     */
    @Test
    public void testIsInside_false_outbound_negative_row() {
        System.out.println("IsInside false outbound negative row");
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(-1,0);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Board. 
     * 
     * in negative column case
     */
    @Test
    public void testIsInside_false_outbound_negative_column() {
        System.out.println(" isInside false out of bound column");
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(1,-10);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Board. 
     * 
     * out of row bound
     */
    @Test
    public void testIsInside_false_outbound_positive_row() {
        System.out.println("IsInside_false outbound positive row");
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(10,1);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Board. 
     * 
     * out of column bound
     */
    @Test
    public void testIsInside_false_outbound_positive_column() {
        System.out.println("IsInside false outbound positive column");
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(2,42);
        assertEquals(expResult, result);
    }
}
