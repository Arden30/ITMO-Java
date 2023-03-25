package pokemons;

import moves.special.AncientPower;
import moves.special.MudBomb;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Swinub extends Pokemon {
    public Swinub(String name, int level)  {
        super(name, level);
        setType(Type.ICE, Type.GROUND);
        setStats(50, 50, 40, 30, 30, 50);
        setMove(new AncientPower(), new MudBomb());
    }
}