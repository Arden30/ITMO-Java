import objects.*;
import abstracts.*;
import exceptions.*;

import java.lang.reflect.Field;

public class Lab4 {
    public static void main(String[] args) {
        Znayka znayka = new Znayka("Знайка", true);
        Shorties shorties = new Shorties("Коротышки");
        Screw vintik = new Screw("Винтика");
        Things rope1 = new Rope("веревку");
        Things fluger = new Fluger("флюгер");

        Human.Actions.Position("наклонное");
        znayka.PushOff();

        try {
            znayka.Fly();
        } catch(IllegalNameException e) {
            System.out.println(e.getMessage());
        }

        // анонимный класс, в котором единожды используется предмет для захватывания
        Catchable CatchObj = new Catchable() {
            @Override
            public void beingCatched(Thingsable thing) {
                System.out.println("Пролетая над " + Places.WORKSHOP.getPlace() + ", он ухватился рукой за" + thing
                        + ", который показывал направление ветра. " + "Это задержало полет. ");
            }
        };
//        Catchable ctch = (Thingsable thing) -> System.out.println("Пролетая над " + Places.WORKSHOP.getPlace() + ", он ухватился рукой за" + thing
//                + ", который показывал направление ветра. " + "Это задержало полет. ");
//        ctch.beingCatched(fluger);
        CatchObj.beingCatched(fluger);

        znayka.OpenDoor();
        shorties.Watch();

        znayka.LookFromWorkshop();
        znayka.ReachGazebo();

        // вызов метода из внутреннего (вложенный статический) класса
        Human.Actions.NotToBe(vintik);

        Znayka znayky = new Znayka("Знайку");
        try {
            shorties.StartPull(rope1, znayky);
        } catch (NoThingsToPull e) {
            System.out.println(e.getMessage());
        }
        znayka.ClimbUp();

        Thingsable wind = new Wind("порыв ветра");
        znayka.WindMoves(wind);

        Things rope2 = new Rope("на веревке обратно");
        znayky.NotScary();
        shorties.AbleToPull(rope2);
        znayka.SomethingHappened();

        Thingsable power = new StrangePower("какая-то сила");
        znayka.Down(power);

        znayka.Fall();
        znayka.Hurts();

        //создание экзмепляра вложенного класса и использование его метода
        Human.Feelings surprised = znayky.new Feelings("удивило, что он снова твердо держится на ногах.");
        surprised.Feel();
        String name = null;
        int number = 0;
        try {
            Extra extra = new Extra();
            Field fieldString = extra.getClass().getDeclaredField("name");
            fieldString.setAccessible(true);
            name = (String)fieldString.get(extra);
            Field fieldInt = extra.getClass().getDeclaredField("number");
            fieldInt.setAccessible(true);
            number = (int)fieldInt.get(extra);
        } catch (NoSuchFieldException | IllegalAccessException e){
            System.out.println(e.getMessage());
        }
        System.out.println();
        System.out.println(name + " " + number);
    }
}
