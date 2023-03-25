package moves.status;

import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove {
    public Rest() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect e = new Effect().turns(2).condition(Status.SLEEP);
        p.addEffect(e);
        p.restore();
        super.applySelfEffects(p);
    }

    @Override
    protected String describe() {
        return "is sleeping";
    }
}
