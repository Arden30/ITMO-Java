package moves.physical;

import ru.ifmo.se.pokemon.*;

public class Superpower extends PhysicalMove {
    public Superpower() {
        super(Type.FIGHTING, 120, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect e = new Effect().stat(Stat.ATTACK, -1).stat(Stat.DEFENSE, -1);
        p.addEffect(e);
        super.applySelfEffects(p);
    }

    @Override
    protected String describe() {
        return "is using Superpower";
    }
}

