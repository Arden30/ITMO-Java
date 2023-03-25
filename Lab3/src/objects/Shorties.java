package objects;

import abstracts.Human;
import abstracts.Humanable;
import abstracts.Places;
import abstracts.Thingsable;

public class Shorties extends Human {
    public Shorties(String name){
        super(name);
    }
    public void StartPull(Thingsable rope1) {
        System.out.print(this.getName() + " принялись тянуть " + rope1.getName());
    }
    public void Pull(Humanable znayka) {
        System.out.print(" и притянули " + znayka.getName() + " " + Places.HOME.getPlace() + ". ");
    }
    public void AbleToPull(Thingsable rope2) {
        System.out.println(this.getName() + " в любой момент могут притянуть его " + rope2.getName() + ".");
    }
}
