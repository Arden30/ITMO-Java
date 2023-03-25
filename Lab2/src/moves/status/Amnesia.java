package moves.status;

import ru.ifmo.se.pokemon.*;

public class Amnesia extends StatusMove {
    public Amnesia() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.SPECIAL_DEFENSE, 2);
        super.applySelfEffects(p);
    }

    @Override
    protected String describe() {
        return "is using Amnesia";
    }
}
