package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test of class position
 * 
 * @author Rémy
 */
public class PositionTest {

    /**
     * Test of next method, of class Position. 
     * 
     * next up
     */
    @Test
    public void testNext_up() {
        System.out.println("next up");
        Position instance = new Position(1, 0);
        Position expResult = new Position(0, 0);
        Position result = instance.next(Direction.UP);
        assertEquals(expResult, result);
    }

    /**
     * Test of next method, of class Position. 
     * 
     * next down
     */
    @Test
    public void testNext_down() {
        System.out.println("next down");
        Position instance = new Position(3, 4);
        Position expResult = new Position(4, 4);
        Position result = instance.next(Direction.DOWN);
        assertEquals(expResult, result);
    }

    /**
     * Test of next method, of class Position. 
     * 
     * next left
     */
    @Test
    public void testNext_left() {
        System.out.println("next left");
        Position instance = new Position(2, 5);
        Position expResult = new Position(2, 4);
        Position result = instance.next(Direction.LEFT);
        assertEquals(expResult, result);
    }

    /**
     * Test of next method, of class Position. 
     * 
     * next right
     */
    @Test
    public void testNext_right() {
        System.out.println("next right");
        Position instance = new Position(5, 2);
        Position expResult = new Position(5, 3);
        Position result = instance.next(Direction.RIGHT);
        assertEquals(expResult, result);
    }

    /**
     * test position A = position B
     */
    @Test
    public void testEquals_sameobject() {
        System.out.println("equals some object");
        Position position1 = new Position(2, 3);
        assertTrue(position1.equals(position1));
    }
}
