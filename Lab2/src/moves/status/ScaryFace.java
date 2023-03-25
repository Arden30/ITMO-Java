package moves.status;

import ru.ifmo.se.pokemon.*;

public class ScaryFace extends StatusMove {
    public ScaryFace() {
        super(Type.NORMAL, 0, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.SPEED, -2);
        super.applyOppEffects(p);
    }

    @Override
    protected String describe() {
        return "is using ScaryFace";
    }
}