package objects;

import abstracts.Human;
import abstracts.Places;
import abstracts.Thingsable;
import exceptions.IllegalNameException;

public class Znayka extends Human {
    public Znayka(String name){
        super(name);
    }
    public Znayka(String name, boolean hurt){
        super(name, hurt);
    }
    public void Fly() {
        // локальный класс для рассчета силы Знайки в методе совершения полета
        class ZnaykaPower {
            private double power;
            private ZnaykaPower(int power) throws IllegalNameException{
                if (power < 0) {
                    throw new IllegalNameException("Сила не может быть отрицательной!!!!");
                }
                else {
                    this.power = power;
                }
            }
            public void PowerCalculation() {
                if (power > 5) {
                    System.out.println("Знайка немного не рассчитал толчка и поднялся выше, чем было надо.");
                } else {
                    System.out.println("Знайка все рассчитал и поднялся на нужную высоту.");
                }
            }
        }
        ZnaykaPower znaykapower = new ZnaykaPower(7);
        znaykapower.PowerCalculation();
    }
    public void PushOff() {
        System.out.println(this.getName() + " с силой оттолкнулся ногами от порога и " +
                "полетел в направлении " + Places.WORKSHOP.getPlace() + ", которая находилась " + Places.NEARHOME.getPlace() + ".");
    }
    public void OpenDoor() {
        System.out.println("Спустившись " + Places.PIPE.getPlace() +
                ", " + this.getName() + " отворил дверь и проник в " + Places.WORKSHOP.getPlace() + ".");
    }
    public void LookFromWorkshop() {
        System.out.println("Через минуту " + this.getName() + " выглянул из " + Places.WORKSHOP.getPlace() + ". ");
    }
    public void ReachGazebo() {
        System.out.print("Одним прыжком " + this.getName() + " достиг " + Places.GAZEBO.getPlace() + " и заглянул внутрь.");
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

    public void SomethingHappened() {
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
            System.out.println("Ощущая во всем теле страшную тяжесть, он с трудом поднялся на ноги и огляделся по сторонам.");
        }
    }
}
