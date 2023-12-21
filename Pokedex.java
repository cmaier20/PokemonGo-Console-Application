import java.util.ArrayList;

public class Pokedex
{
    private ArrayList<Pokemon> myPokeDex = new ArrayList<Pokemon>();

    public void addToDex(Pokemon pokemon)
    {
        myPokeDex.add(pokemon);
    }

    @Override
    public String toString()
    {
        String pokedex= "";
        for(Pokemon p: myPokeDex)
        {
            pokedex += (p.toString()+ "\n");
        }

        return pokedex;
    }
}
