package objects;

import abstracts.Human;
import abstracts.Places;
import abstracts.Thingsable;

public class Znayka extends Human{

    public Znayka(String name){
        super(name);
    }
    public Znayka(String name, boolean hurt){
        super(name, hurt);
    }
    public void ClimbUp() {
        System.out.println(this.getName() + " мгновенно вскарабкался " +
                Places.PIPE.getPlace() + " " + Places.ROOF1.getPlace());
    }
    public void WindMoves(Thingsable wind) {
        System.out.println("и уже хотел оглядеться по сторонам, но налетевший неожиданно " + wind.getName() + " сдул его "
                + Places.ROOF2.getPlace() + " и понес в сторону.");
    }
    public void NotScary() {
        System.out.print("Это не испугало " + this.getName() + ", так как он знал, что ");
    }

    public void SmthHappened() {
        System.out.println("Ему, однако, не удалось ничего разглядеть, " +
                "так как в следующий момент произошло то, чего никто не ожидал.");
    }
    public void Down(Thingsable power) {
        System.out.println("Не долетев " + Places.FENCE.getPlace() + ", " + this.getName()
                + " начал стремительно падать, словно " + power.getName() + " неожиданно потянула его вниз.");
    }

    public void Fall() {
        System.out.println("Шлепнувшись с размаху " + Places.GROUND.getPlace() +
                ", он растянулся во весь рост и не успел даже сообразить, что произошло.");
    }
    public void Hurts() {
        if (isHurt()) {
            System.out.print("Ощущая во всем теле страшную тяжесть, он с трудом поднялся на ноги и огляделся по сторонам.");
        }
    }
}
