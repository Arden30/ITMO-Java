package moves.special;

import ru.ifmo.se.pokemon.*;

public class MudBomb extends SpecialMove {
    public MudBomb() {
        super(Type.GROUND, 65, 85);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.3)
            p.setMod(Stat.ACCURACY, -1);
        super.applyOppEffects(p);
    }

    @Override
    protected String describe() {
        return "is using MudBomb";
    }
}

