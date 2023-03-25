package pokemons;

import moves.special.AncientPower;
import moves.special.MudBomb;
import moves.status.Amnesia;
import moves.status.ScaryFace;
import ru.ifmo.se.pokemon.Type;

public class Mamoswine extends Piloswine {
    public Mamoswine(String name, int level)  {
        super(name, level);
        setStats(110, 130, 80, 70, 60, 80);
        addMove(new ScaryFace());
    }
}
