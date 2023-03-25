package moves.status;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class BabyDollEyes extends StatusMove {
    public BabyDollEyes() {
        super(Type.FAIRY, 0, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.ATTACK, -1);
        super.applyOppEffects(p);
    }

    @Override
    protected String describe() {
        return "is using BabyDollEyes";
    }
}
