package moves.special;

import ru.ifmo.se.pokemon.*;

public class AncientPower extends SpecialMove {
    public AncientPower() {
        super(Type.ROCK, 60, 100);
    }
    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect e = new Effect().chance(0.1).stat(Stat.ATTACK, 1).stat(Stat.DEFENSE, 1).stat(Stat.SPECIAL_ATTACK, 1).stat(Stat.SPECIAL_DEFENSE, 1).stat(Stat.SPEED, 1);
        p.addEffect(e);
        super.applySelfEffects(p);
    }

    @Override
    protected String describe() {
        return "is using AncientPower";
    }
}

