package moves.physical;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class DynamicPunch extends PhysicalMove {
    public DynamicPunch() {
        super(Type.FIGHTING, 100, 50);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect.confuse(p);
        super.applyOppEffects(p);
    }

    @Override
    protected String describe() {
        return "is using DynamicPunch";
    }
}
