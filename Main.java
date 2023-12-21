import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);

        final float cpm = 0.49985844f;
        Random random = new Random();

        Pokedex myDex = new Pokedex();
        Pokemon pokemon;
        float multipliers;
        float catch_probability;


        boolean quit = false;
        boolean quit_catch = false;

        while(!quit)
        {
            //Spawns a pokemon
            pokemon = spawn();

            while(!quit_catch)
            {


                multipliers = throwBall();
                catch_probability =(float)(1f-Math.pow((1f-(pokemon.getBaseCatchRate()/(2f*cpm))),multipliers));

                float random_num = random.nextFloat();
                if (random_num < catch_probability)
                {
                    System.out.println(pokemon.toString() + " was caught!");
                    myDex.addToDex(pokemon);
                    quit_catch = true;
                }
                else
                {
                    System.out.println("Oops, "+pokemon.toString()+" jumped out, try again!");
                }

            }

            System.out.println("Would you like to continue catching Pokemon? (Yes/No)");
            String option = scanner.nextLine();
            if(option.equalsIgnoreCase("No"))
            {
                System.out.println("Final Dex Entries");
                System.out.println("------------------------------");
                System.out.println(myDex.toString());
                quit = true;
            }

            quit_catch = false;

        }



    }

    public static Pokemon spawn()
    {
        Random random = new Random();
        int level = random.nextInt(21);

        int spawn_number = random.nextInt(4);

        if(spawn_number == 1)
        {
            Pokemon pokemon = new Bulbasaur(level);
            System.out.println("You encounter a level "+pokemon.getLevel()+" Bulbasaur!");
            return pokemon;
        }
        else if(spawn_number == 2)
        {
            Pokemon pokemon = new Charmander(level);
            System.out.println("You encounter a level "+pokemon.getLevel()+" Charmander!");
            return pokemon;
        }
        else
        {
            Pokemon pokemon = new Caterpie(level);
            System.out.println("You encounter a level "+pokemon.getLevel()+" Caterpie!");
            return pokemon;
        }
    }

    public static float throwBall()
    {
        Scanner scanner = new Scanner(System.in);
        float ballMultiplier = 0.0f,berryMultiplier = 0.0f, curveMultiplier = 0.0f;

        System.out.println("Which ball do you wish to use? (Poke, Great, or Ultra)");

        String ball = scanner.nextLine();

        if(ball.equalsIgnoreCase("Poke"))
        {
            ballMultiplier = 1.0f;
            System.out.println("You chose Poke!");
        }
        else if(ball.equalsIgnoreCase("Great"))
        {
            ballMultiplier = 1.5f;
            System.out.println("You chose Great!");
        }
        else if(ball.equalsIgnoreCase("Ultra"))
        {
            ballMultiplier = 2.0f;
            System.out.println("You chose Ultra!");
        }

        System.out.println("Which berry would you like to use? (None, Razz, SilverPinap, or GoldenRazz?)");

        String berry = scanner.nextLine();

        if(berry.equalsIgnoreCase("Razz"))
        {
            berryMultiplier = 1.5f;
            System.out.println("You chose Razz!");
        }
        else if(berry.equalsIgnoreCase("SilverPinap"))
        {
            berryMultiplier = 1.8f;
            System.out.println("You chose SilverPinap!");
        }
        else if(berry.equalsIgnoreCase("GoldenRazz"))
        {
            berryMultiplier = 2.5f;
            System.out.println("You chose GoldenRazz!");
        }
        else
        {
            berryMultiplier = 1.0f;
            System.out.println("You chose to not use a berry");
        }

        System.out.println("Are you throwing a curve ball? (Yes/No)");

        String curve = scanner.nextLine();

        if(curve.equalsIgnoreCase("Yes"))
        {
            curveMultiplier = 1.7f;
            System.out.println("You throw a curveball!");
        }
        else
        {
            curveMultiplier = 1.0f;
            System.out.println("You throw the ball regularly");
        }

        return (ballMultiplier * berryMultiplier * curveMultiplier);

    }


}
