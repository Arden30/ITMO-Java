package objects;

import abstracts.Human;
import abstracts.Humanable;
import abstracts.Places;
import abstracts.Thingsable;
import exceptions.NoThingsToPull;
import abstracts.Things;
public class Shorties extends Human {
    public Shorties(String name){
        super(name);
    }
    public void Watch() {
        System.out.print(this.getName() + " с напряжением следили за его действиями. ");
    }
    public void StartPull(Things rope1, Humanable znayka) throws NoThingsToPull {
        if (rope1.getName().length() == 0) {
            throw new NoThingsToPull(this.getName() + " не могут никого тянуть, нечем... ");
        } else {
            System.out.print(this.getName() + " принялись тянуть " + rope1.getName() +
                    " и притянули " + znayka.getName() + " " + Places.BACKHOME.getPlace() + ". ");
        }
    }
    public void AbleToPull(Thingsable rope2) {
        System.out.println(this.getName() + " в любой момент могут притянуть его " + rope2.getName() + ".");
    }
}
