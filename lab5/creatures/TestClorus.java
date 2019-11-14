package creatures;

import huglife.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;

public class TestClorus {

    @Test
    public void testBasics() {
        Clorus c = new Clorus(3.0);
        assertEquals(3.0, c.energy(), 0.01);
        assertEquals(new Color(34, 0, 231), c.color());
        c.move();
        assertEquals(2.97, c.energy(), 0.01);
        c.stay();
        assertEquals(2.98, c.energy(), 0.01);
        c.move();
        assertEquals(2.95, c.energy(), 0.01);
        c.stay();
        assertEquals(2.96, c.energy(), 0.01);
    }

    @Test
    public void testAttack() {
        Clorus c = new Clorus(3.0);
        Plip prey = new Plip(2.5);
        c.attack(prey);
        assertEquals(5.5, c.energy(), 0.01);
    }
    
    @Test
    public void testReplicate() {
        Clorus c = new Clorus(3.0);
        Clorus child = c.replicate();
        assertEquals(child.energy(), c.energy(), 0.01);
        assertEquals(1.5, c.energy(), 0.01);
        assertNotEquals(child, c);
    }

    @Test
    public void testActions() {
        //Case 1: no empty squares, STAY.
        Clorus c = new Clorus(1.0);
        HashMap<Direction, Occupant> noEmpty = new HashMap<>();
        noEmpty.put(Direction.TOP, new Impassible());
        noEmpty.put(Direction.BOTTOM, new Impassible());
        noEmpty.put(Direction.LEFT, new Impassible());
        noEmpty.put(Direction.RIGHT, new Impassible());
        
        Action actual = c.chooseAction(noEmpty);
        Action expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);


        //Case 2: ATTACK if any plips are seen.
        HashMap<Direction, Occupant> hasPlip = new HashMap<>();
        hasPlip.put(Direction.TOP, new Plip(2.0));
        hasPlip.put(Direction.BOTTOM, new Empty());
        hasPlip.put(Direction.LEFT, new Empty());
        hasPlip.put(Direction.RIGHT, new Empty());

        actual = c.chooseAction(hasPlip);
        expected = new Action(Action.ActionType.ATTACK, Direction.TOP);

        assertEquals(3.0, c.energy(), 0.01);
        assertEquals(expected, actual);


        //Case 3: REPLICATE if energy is greater or equal to one.
        c = new Clorus(3.0);
        HashMap<Direction, Occupant> allEmpty = new HashMap<>();
        allEmpty.put(Direction.TOP, new Empty());
        allEmpty.put(Direction.BOTTOM, new Empty());
        allEmpty.put(Direction.LEFT, new Empty());
        allEmpty.put(Direction.RIGHT, new Empty());

        actual = c.chooseAction(allEmpty);
        Action unexpected = new Action(Action.ActionType.STAY);

        assertNotEquals(unexpected, actual);

        //Case 4: MOVE to a random empty square.
        c = new Clorus(0.5);
        actual = c.chooseAction(allEmpty);
        assertNotEquals(unexpected, actual);
    }

}
