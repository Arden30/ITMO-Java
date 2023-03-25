import abstracts.Things;
import abstracts.Thingsable;
import objects.*;

public class Lab3 {
    public static void main(String[] args) {
        Znayka znayka = new Znayka("Знайка", true);
        Shorties shorties = new Shorties("Коротышки");
        Things rope1 = new Rope("веревку");

        shorties.StartPull(rope1);

        Znayka znayky = new Znayka("Знайку");

        shorties.Pull(znayky);
        znayka.ClimbUp();

        Thingsable wind = new Wind("порыв ветра");
        znayka.WindMoves(wind);

        Things rope2 = new Rope("на веревке обратно");
        znayky.NotScary();
        shorties.AbleToPull(rope2);
        znayka.SmthHappened();

        Thingsable power = new StrangePower("какая-то сила");
        znayka.Down(power);

        znayka.Fall();
        znayka.Hurts();
    }
}
