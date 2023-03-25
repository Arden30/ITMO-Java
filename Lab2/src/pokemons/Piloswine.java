package pokemons;

import moves.special.AncientPower;
import moves.special.MudBomb;
import moves.status.Amnesia;
import ru.ifmo.se.pokemon.Type;

public class Piloswine extends Swinub {
    public Piloswine(String name, int level)  {
        super(name, level);
        setStats(100, 100, 80, 60, 60, 50);
        addMove(new Amnesia());
    }
}

