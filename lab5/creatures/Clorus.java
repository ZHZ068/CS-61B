package creatures;

import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;

import java.awt.Color;
import java.util.*;

public class Clorus extends Creature {
    /** color: red, green, blue */
    private int g;
    private int r;
    private int b;

    public Clorus(double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    public Color color() {
        r = 34;
        g = 0;
        b = 231;
        return color(r, g, b);
    }

    public void move() {
        energy -= 0.03;
        if (energy < 0) {
            energy = 0;
        }
    }

    public void stay() {
        energy += 0.01;
    }

    public Clorus replicate() {
        Clorus babyClorus = new Clorus(energy/2);
        this.energy /= 2;
        return babyClorus;
    }

    public void attack(Creature c) {
        this.energy += c.energy();
    }

    /** Clorus actions:
     * 1. If no empty adjacent spaces, STAY;
     * (Clorus still STAYs if surrounded by 4 Plips due to lack of empty squares)
     * 2. Otherwise, if any Plips are seen, ATTACK randomly;
     * 3. Otherwise, if energy >= 1.0, REPLICATE to a random empty square;
     * 4. Otherwise, MOVE to a random empty square.
     */


    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        List<Direction> emptyNeighbors = new ArrayList<>();
        List<Direction> plipLocation = new ArrayList<>();

        for (Direction key: neighbors.keySet()) {
            Occupant ocu = neighbors.get(key);
            if (ocu.name().equals("empty")) {
                emptyNeighbors.add(key);
            } else if (ocu.name().equals("plip")) {
                plipLocation.add(key);
            }
        }

        /** If no empty adjacent spaces, STAY */
        if (emptyNeighbors.isEmpty()){
            return new Action(Action.ActionType.STAY);
        }

        Random r = new Random();
        Direction randomEmpty = emptyNeighbors.get((r.nextInt(emptyNeighbors.size())));


        if (!plipLocation.isEmpty()){
            Direction randomPlip =  plipLocation.get((r.nextInt(plipLocation.size())));
            Creature attackedPilp = (Creature) neighbors.get(randomPlip);
            attack(attackedPilp);
            return new Action(Action.ActionType.ATTACK, randomPlip);
        } else if (energy >= 1.0) {
            return new Action(Action.ActionType.REPLICATE, randomEmpty);
        } else {
            return new Action(Action.ActionType.MOVE, randomEmpty);
        }

    }

}
