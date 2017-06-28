package task_02;

import task_02.ducks.DecoyDuck;
import task_02.ducks.Duck;

public class DuckRacer {
    private Duck duck;
    private int distance = 0;
    private boolean winner = false;

    public Duck getDuck() {
        if (duck == null) {
            duck = new DecoyDuck();
        }
        return duck;
    }

    public void setDuck(Duck duck) {
        this.duck = duck;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
