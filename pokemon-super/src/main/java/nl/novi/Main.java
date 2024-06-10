package nl.novi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

  // First i will one super class pokemon

  // I will make 4 sub classes ( this wil serve as fire, water, grass, and electric)

  // These will in turn also serve out as charmender, squirtle, bulbasaur and pikachu

  // Later i will make more subclasses so serve out more pokemon

  // First I will make 2 instances of different pokemons.
  // Then I will try to re-inact them to do a fight

  public static void main(String[] args) {

    CombinedPokemon volcanion = new CombinedPokemon("Volcanion", 50, 100, 0, 50, 50, 30, new FirePokemon(), new WaterPokemon());
    if ((volcanion.typeA instanceof FirePokemon && volcanion.typeB instanceof WaterPokemon) ||
      (volcanion.typeB instanceof FirePokemon && volcanion.typeA instanceof WaterPokemon)) {
      FirePokemon firePokemon = (FirePokemon) volcanion.typeA;
      WaterPokemon waterPokemon = (WaterPokemon) volcanion.typeB;
      String test = waterPokemon.getName();
      System.out.println(test);
    }

    // This pokemons need to be put into an array and there I will make a ramdom  object
    ElectricPokemon pikachu = new ElectricPokemon("Pikachu", 50, 100, 0, 50, 50, 30); // your current pokemon.

    // List of pokemon to fight with
    List<Pokemon> pokemons = new ArrayList<Pokemon>();
//    pokemons.add(new FirePokemon("Charmender", 50, 100, 0, 50, 50, 20));
//    pokemons.add(new WaterPokemon("Squirtle", 50, 100, 0, 50, 50, 20));
//    pokemons.add(new GrassPokemon("Bulbasaur", 50, 100, 0, 50, 50, 30));
    pokemons.add(volcanion);
    Scanner scanner = new Scanner(System.in);
    String input;
    String[] choises = {"1", "2", "3"};
    // Randomize pokemon
    Random random = new Random();
    int randomIndex = random.nextInt(pokemons.size());
    // The pokemon that will be fight with.
    Pokemon randomPokemon = pokemons.get(randomIndex);
    // the following a some variables to keep up the score and one for the troffee
    int countWon = 0;

    // this game will just give a couple of choises:
    //  _ start the game
    //  - choose attack
    //  - eat - to regain hp

    // Start of the game
    System.out.println("Start the game, press y, to exit press any other key.");
    input = scanner.nextLine();
    if (input.equals("y")) {
      // this while loop will break out if the game has been won 3 times
      while (true) {
        if (countWon >= 3) {
          System.out.println("Congratulations, you just won the tournament");
          break;

        } else {

          // the following will cast the instance of into the specific type
          if (randomPokemon instanceof FirePokemon) {
            FirePokemon firePokemon = (FirePokemon) randomPokemon;
            System.out.println("Goodluck, your challenger is " + firePokemon.getName());
            // create a while loop to continue the fight
            while (true) {
              if (pikachu.getHp() <= 0) {
                System.out.println("You lost the game!");
                break;
              }
              System.out.println("You can choose the following:");
              System.out.println("1 for " + pikachu.getAttack() + " - 2 to upgrade  your power with " + pikachu.getPowerName() +
                " - 3 to upgrade your defence with " + pikachu.getDefenceName());
              input = scanner.nextLine();
              // your turn
              if (input.equals("1")) {
                pikachu.thunderShock(firePokemon);
                printOutValuesDefender(firePokemon);
              } else if (input.equals("2")) {
                pikachu.increaseVoltage();
              } else if (input.equals("3")) {
                pikachu.increaseSpeed();
              }
              if (firePokemon.getHp() <= 0) {
                System.out.println("You won!");
                pokemons.remove(firePokemon);
                if (pokemons.size() > 0) {
                  randomIndex = random.nextInt(pokemons.size());
                  randomPokemon = pokemons.get(randomIndex);
                }
                countWon++;
                break;
              }
              System.out.println();
              //challengers turn
              Random index = new Random();
              int ramdomIndex = index.nextInt(choises.length);
              String randomChoise = choises[ramdomIndex];
              if (randomChoise.equals("1")) {
                firePokemon.flameThrower(pikachu);
                printOutValuesDefender(pikachu);
                System.out.println();
              } else if (randomChoise.equals("2")) {
                firePokemon.increaseFlameTemperature();
                System.out.println();
              } else if (randomChoise.equals("3")) {
                firePokemon.increaseHeatShield();
                System.out.println();
              }
            }
            // the following will cast the instance of into the specific type
          } else if (randomPokemon instanceof WaterPokemon) {
            WaterPokemon waterPokemon = (WaterPokemon) randomPokemon;
            System.out.println(waterPokemon.getHp());
            System.out.println("Goodluck, your challenger is " + waterPokemon.getName());
            // create a while loop to continue the fight
            while (true) {
              if (pikachu.getHp() <= 0) {
                System.out.println("You lost the game!");
                break;
              }
              System.out.println("You can choose the following:");
              System.out.println("1 for " + pikachu.getAttack() + " - 2 to upgrade  your power with " + pikachu.getPowerName() +
                " - 3 to upgrade your defence with " + pikachu.getDefenceName());
              input = scanner.nextLine();
              if (input.equals("1")) {
                pikachu.thunderShock(waterPokemon);
                printOutValuesDefender(waterPokemon);
              } else if (input.equals("2")) {
                pikachu.increaseVoltage();
              } else if (input.equals("3")) {
                pikachu.increaseSpeed();
              }
              if (waterPokemon.getHp() <= 0) {
                System.out.println("You won!");
                pokemons.remove(waterPokemon);
                if (pokemons.size() > 0) {
                  randomIndex = random.nextInt(pokemons.size());
                  randomPokemon = pokemons.get(randomIndex);
                }
                countWon++;
                break;
              }
              System.out.println();
              //challengers turn
              Random index = new Random();
              int ramdomIndex = index.nextInt(choises.length);
              String randomChoise = choises[ramdomIndex];
              if (randomChoise.equals("1")) {
                waterPokemon.waterGun(pikachu);
                printOutValuesDefender(pikachu);
                System.out.println();
              } else if (randomChoise.equals("2")) {
                waterPokemon.increaseWaterPressure();
                System.out.println();
              } else if (randomChoise.equals("3")) {
                waterPokemon.increasSwimmingSpeed();
                System.out.println();
              }
            }
            // the following will cast the instance of into the specific type
          } else if (randomPokemon instanceof GrassPokemon) {
            GrassPokemon grassPokemon = (GrassPokemon) randomPokemon;
            System.out.println(grassPokemon.getHp());
            System.out.println("Goodluck, your challenger is " + grassPokemon.getName());
            // create a while loop to continue the fight
            while (true) {
              if (pikachu.getHp() <= 0) {
                System.out.println("You lost the game!");
                break;
              }
              System.out.println("You can choose the following:");
              System.out.println("1 for " + pikachu.getAttack() + " - 2 to upgrade  your power with " + pikachu.getPowerName() +
                " - 3 to upgrade your defence with " + pikachu.getDefenceName());
              input = scanner.nextLine();
              if (input.equals("1")) {
                pikachu.thunderShock(grassPokemon);
                printOutValuesDefender(grassPokemon);
              } else if (input.equals("2")) {
                pikachu.increaseVoltage();
              } else if (input.equals("3")) {
                pikachu.increaseSpeed();
              }
              if (grassPokemon.getHp() <= 0) {
                System.out.println("You won!");
                pokemons.remove(grassPokemon);
                if (pokemons.size() > 0) {
                  randomIndex = random.nextInt(pokemons.size());
                  randomPokemon = pokemons.get(randomIndex);
                }
                countWon++;
                break;
              }
              System.out.println();
              //challengers turn
              Random index = new Random();
              int ramdomIndex = index.nextInt(choises.length);
              String randomChoise = choises[ramdomIndex];
              if (randomChoise.equals("1")) {
                grassPokemon.razorLead(pikachu);
                printOutValuesDefender(pikachu);
                System.out.println();
              } else if (randomChoise.equals("2")) {
                grassPokemon.increaseLeafSharpness();
                System.out.println();
              } else if (randomChoise.equals("3")) {
                grassPokemon.increasePhotosynthesisRate();
                System.out.println();
              }
            }
          } else if (randomPokemon instanceof CombinedPokemon) {
            CombinedPokemon combinedPokemon = (CombinedPokemon) randomPokemon;

            if ((combinedPokemon.typeA instanceof FirePokemon && combinedPokemon.typeB instanceof WaterPokemon) ||
              (combinedPokemon.typeB instanceof FirePokemon && combinedPokemon.typeA instanceof WaterPokemon)) {
              FirePokemon firePokemon = (FirePokemon) combinedPokemon.typeA;
              WaterPokemon waterPokemon = (WaterPokemon) combinedPokemon.typeB;
              break;
            }
          }
        }
      }
    } else {
      System.out.println("The game has been stopped.");
    }

    // this was a manual test
//    pikachu.increaseVoltage();
//    pikachu.increaseVoltage();
//    pikachu.increaseVoltage();
//    pikachu.increaseVoltage();
//    pikachu.increaseSpeed();
//    pikachu.increaseSpeed();
//    pikachu.increaseSpeed();
//    System.out.println("Defence level of pikachu: " + pikachu.getCurrentDefenceLevel());
//    squirtle.waterGun(pikachu);
//    System.out.println("Defence level of pikachu: " + pikachu.getCurrentDefenceLevel());

  }

  // with every draw there will be a report of the damage being done and the current hp
  // when there is a winner this will be printed out

  // eventually when you win you continue to the next pokemons
  // if you win 4 times in a row you wil win a trofea

  public static void printOutValuesDefender(Pokemon pokemon) {
    pokemon.speaks();
    System.out.println("The hp of " + pokemon.getName() + " is " + pokemon.getHp());
  }
}

