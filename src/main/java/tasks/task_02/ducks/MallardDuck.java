package tasks.task_02.ducks;

import tasks.task_02.DuckConfig;
import tasks.task_02.fly.FlyWithWings;
import tasks.task_02.quack.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }

    @Override
    public void display() {
        System.out.print(DuckConfig.MALLARD_DUCK);
        getFlyBehavior().displayFlyBehavior();
    }
}
