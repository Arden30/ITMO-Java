import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;
import pokemons.*;

public class Lab2 {
    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon pheromosa = new Pheromosa("Pher", 100);
        Pokemon eevee = new Eevee("Eev", 100);
        Pokemon jolteon = new Jolteon("Jolt", 100);
        Pokemon swinub = new Swinub("Swin", 100);
        Pokemon piloswine = new Piloswine("Pilos", 100);
        Pokemon mamoswine = new Mamoswine("Mamos", 100);
        b.addAlly(jolteon);
        b.addAlly(eevee);
        b.addAlly(pheromosa);
        b.addFoe(swinub);
        b.addFoe(piloswine);
        b.addFoe(mamoswine);
        b.go();
    }
}