package nl.novi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
  //  First i will one super class pokemon
  //  I will make 4 sub classes ( this wil serve as fire, water, grass, and electric)
  //  These will in turn also serve out as charmender, squirtle, bulbasaur and pikachu etc
  //  Later i will make more subclasses so serve out more pokemon - This would become combinedClasses that use composition
  //  I will reinact them to make a fight manually
  //  Later I will create the logic that you really can play the game

  public static void main(String[] args) {

    // This pokemons need to be put into an array and there I will make a ramdom  object
    ElectricPokemon pikachu = new ElectricPokemon("Pikachu", 50, 100, 0, 50, 50, 30); // your current pokemon.

    // List of pokemon to fight with
    List<Pokemon> pokemons = new ArrayList<Pokemon>();
    pokemons.add(new FirePokemon("Charmender", 50, 100, 0, 50, 50, 20));
    pokemons.add(new WaterPokemon("Squirtle", 50, 100, 0, 50, 50, 20));
    pokemons.add(new GrassPokemon("Bulbasaur", 50, 100, 0, 50, 50, 30));
    // Combined pokemons ( 2 combined combinations possible)
    pokemons.add(new CombinedPokemon("Volcanion", 50, 100, 0, 50, 50, 30, new FirePokemon("volcanion"),
      new WaterPokemon("volcanion")));
    pokemons.add(new CombinedPokemon("Ludicolo", 50, 100, 0, 50, 50, 20, new WaterPokemon("ludicolo"), new GrassPokemon("ludicolo")));

    // Initiate Scanner object
    Scanner scanner = new Scanner(System.in);
    String input;
    String[] choises = {"1", "2", "3"}; // This will be used for serving the 3 choises available in the 'regular' pokemons
    String[] choisesCombined = {"1", "2", "3", "4", "5", "6"}; // This will be served for the combined pokemons

    // Randomize pokemon
    Random random = new Random();
    int randomIndex = random.nextInt(pokemons.size());
    // The pokemon that will be fight with.
    Pokemon randomPokemon = pokemons.get(randomIndex);

    //  - this game will just give a couple of choises:
    //  - start the game( this will start a tournament of 3 matches)
    //  - choose attack( you are only to play with pikachu for now)
    //  - defend move to add defence against challenger
    //  - power up move will add extra damage to challenger
    //  - with every draw there will be a report of the damage being done and the current hp
    //  - when there is a winner this will be printed out
    //  - eventually when you win you continue to the next pokemons
    //  - if you win 4 times in a row you wil win the tournament
    //  - you will always get a new challenger based how many are stored in the List of pokemons.

    // Start of the game
    System.out.println("Start the game, press y, to exit press any other key.");
    input = scanner.nextLine();
    if (input.equals("y")) {
      // this while loop will break out if the game has been won 3 times
      while (true) {
        if (pokemons.isEmpty()) {
          System.out.println("Congratulations, you just won the tournament");
          break;
        }
        else {

          // the following will cast the randomPokeom instance of into the specific type
          if (randomPokemon instanceof FirePokemon firePokemon) {
            System.out.println("Goodluck, your challenger is " + firePokemon.getName());
            // create a while loop to continue the fight
            while (true) {
              if (lostMatch(pikachu)) {
                break;
              }
              printOutRegularOptions(pikachu);
              input = scanner.nextLine();
              // your turn
              performChoise(pikachu, firePokemon, input);
              if (wonMatch(firePokemon)) {
                pokemons.remove(firePokemon);
                if (!pokemons.isEmpty()) {
                  randomIndex = random.nextInt(pokemons.size());
                  randomPokemon = pokemons.get(randomIndex);
                }
                break;
              }
              System.out.println();
              //challengers turn
              Random index = new Random();
              int ramdomIndex = index.nextInt(choises.length);
              String randomChoise = choises[ramdomIndex];
              perfomChoiseChallenger(pikachu, firePokemon, randomChoise);
            }
            // the following will cast the instance of into the specific type
          }
          // the following will cast the randomPokeom instance of into the specific type
          else if (randomPokemon instanceof WaterPokemon waterPokemon) {
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
              }
              else if (input.equals("2")) {
                pikachu.increaseVoltage();
              }
              else if (input.equals("3")) {
                pikachu.increaseSpeed();
              }
              if (waterPokemon.getHp() <= 0) {
                System.out.println("You won!");
                pokemons.remove(waterPokemon);
                if (!pokemons.isEmpty()) {
                  randomIndex = random.nextInt(pokemons.size());
                  randomPokemon = pokemons.get(randomIndex);
                }
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
              }
              else if (randomChoise.equals("2")) {
                waterPokemon.increaseWaterPressure();
                System.out.println();
              }
              else if (randomChoise.equals("3")) {
                waterPokemon.increasSwimmingSpeed();
                System.out.println();
              }
            }
            // the following will cast the instance of into the specific type
          }
          // the following will cast the randomPokeom instance of into the specific type
          else if (randomPokemon instanceof GrassPokemon grassPokemon) {
            //  GrassPokemon grassPokemon = (GrassPokemon) randomPokemon; I kept on example of how I did it withouthn the casting
            //  directly into grasspokemon inside thje else if
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
              }
              else if (input.equals("2")) {
                pikachu.increaseVoltage();
              }
              else if (input.equals("3")) {
                pikachu.increaseSpeed();
              }
              if (grassPokemon.getHp() <= 0) {
                System.out.println("You won!");
                pokemons.remove(grassPokemon);
                if (pokemons.size() > 0) {
                  randomIndex = random.nextInt(pokemons.size());
                  randomPokemon = pokemons.get(randomIndex);
                }
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
              }
              else if (randomChoise.equals("2")) {
                grassPokemon.increaseLeafSharpness();
                System.out.println();
              }
              else if (randomChoise.equals("3")) {
                grassPokemon.increasePhotosynthesisRate();
                System.out.println();
              }
            }
          }
          // the following will cast the randomPokeom instance of into the specific type
          else if (randomPokemon instanceof CombinedPokemon combinedPokemon) {
            // the following will cast the combinedPokemon instance of into 2 specific types
            if ((combinedPokemon.typeA instanceof FirePokemon && combinedPokemon.typeB instanceof WaterPokemon) ||
              (combinedPokemon.typeB instanceof FirePokemon && combinedPokemon.typeA instanceof WaterPokemon)) {
              FirePokemon firePokemon = (FirePokemon) combinedPokemon.typeA;
              WaterPokemon waterPokemon = (WaterPokemon) combinedPokemon.typeB;

              System.out.println("Goodluck, your challenger is " + combinedPokemon.getName());
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
                  pikachu.thunderShock(combinedPokemon);
                  printOutValuesDefender(combinedPokemon);
                }
                else if (input.equals("2")) {
                  pikachu.increaseVoltage();
                }
                else if (input.equals("3")) {
                  pikachu.increaseSpeed();
                }
                if (combinedPokemon.getHp() <= 0) {
                  System.out.println("You won!");
                  pokemons.remove(combinedPokemon);
                  if (pokemons.size() > 0) {
                    randomIndex = random.nextInt(pokemons.size());
                    randomPokemon = pokemons.get(randomIndex);
                  }
                  break;
                }
                System.out.println();
                //challengers turn
                Random index = new Random();
                int ramdomIndex = index.nextInt(choisesCombined.length);
                String randomChoise = choisesCombined[ramdomIndex];
                switch (randomChoise) {
                  case "1":
                    firePokemon.flameThrower(pikachu);
                    printOutValuesDefender(pikachu);
                    System.out.println();
                    break;

                  case "2":
                    waterPokemon.waterGun(pikachu);
                    printOutValuesDefender(pikachu);
                    System.out.println();
                    break;
                  case "3":
                    firePokemon.increaseFlameTemperature();
                    System.out.println();
                    break;
                  case "4":
                    waterPokemon.increaseWaterPressure();
                    System.out.println();
                  case "5":
                    firePokemon.increaseHeatShield();
                    System.out.println();
                    break;
                  case "6":
                    waterPokemon.increasSwimmingSpeed();
                    System.out.println();
                    break;
                  default:
                    System.out.println("Invalid choice");
                    break;
                }
              }
            }
            else if ((combinedPokemon.typeA instanceof WaterPokemon && combinedPokemon.typeB instanceof GrassPokemon) ||
              (combinedPokemon.typeB instanceof WaterPokemon && combinedPokemon.typeA instanceof GrassPokemon)) {
              WaterPokemon waterPokemon = (WaterPokemon) combinedPokemon.typeA;
              GrassPokemon grassPokemon = (GrassPokemon) combinedPokemon.typeB;

              System.out.println("Goodluck, your challenger is " + combinedPokemon.getName());
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
                  pikachu.thunderShock(combinedPokemon);
                  printOutValuesDefender(combinedPokemon);
                }
                else if (input.equals("2")) {
                  pikachu.increaseVoltage();
                }
                else if (input.equals("3")) {
                  pikachu.increaseSpeed();
                }
                if (combinedPokemon.getHp() <= 0) {
                  System.out.println("You won!");
                  pokemons.remove(combinedPokemon);
                  if (pokemons.size() > 0) {
                    randomIndex = random.nextInt(pokemons.size());
                    randomPokemon = pokemons.get(randomIndex);
                  }
                  break;
                }
                System.out.println();
                //challengers turn
                Random index = new Random();
                int ramdomIndex = index.nextInt(choisesCombined.length);
                String randomChoise = choisesCombined[ramdomIndex];
                switch (randomChoise) {
                  case "1":
                    waterPokemon.waterGun(pikachu);
                    printOutValuesDefender(pikachu);
                    System.out.println();
                    break;

                  case "2":
                    grassPokemon.razorLead(pikachu);
                    printOutValuesDefender(pikachu);
                    System.out.println();
                    break;
                  case "3":
                    waterPokemon.increaseWaterPressure();
                    System.out.println();
                    break;
                  case "4":
                    grassPokemon.increasePhotosynthesisRate();
                    System.out.println();
                  case "5":
                    waterPokemon.increasSwimmingSpeed();
                    System.out.println();
                    break;
                  case "6":
                    grassPokemon.increasePhotosynthesisRate();
                    System.out.println();
                    break;
                  default:
                    System.out.println("Invalid choice");
                    break;
                }
              }
            }
          }
        }
      }
    }
    else {
      System.out.println("The game has been stopped.");
    }
  }

  public static void printOutValuesDefender(Pokemon pokemon) {
    pokemon.speaks();
    System.out.println("The hp of " + pokemon.getName() + " is " + pokemon.getHp());
  }

  public static boolean lostMatch(Pokemon pokemon) {
    if (pokemon.getHp() <= 0) {
      System.out.println("You lost the game!");
      return true;
    }
    return false;
  }

  public static boolean wonMatch(Pokemon pokemon) {
    if (pokemon.getHp() <= 0) {
      System.out.println("You Won the game!");
      return true;
    }
    return false;
  }

  public static void printOutRegularOptions(Pokemon pokemon) {
    System.out.println("You can choose the following:");
    System.out.println("1 for " + pokemon.getAttack() + " - 2 to upgrade  your power with " + pokemon.getPowerName() +
      " - 3 to upgrade your defence with " + pokemon.getDefenceName());
  }

  public static void performChoise(Pokemon mainPokemon, Pokemon challenger, String input) {
    if (input.equals("1")) {
      if (mainPokemon instanceof ElectricPokemon electricPokemon) {
        electricPokemon.thunderShock(challenger);
      }
      printOutValuesDefender(challenger);
    }
    else if (input.equals("2")) {
      if (mainPokemon instanceof ElectricPokemon electricPokemon)
        electricPokemon.increaseVoltage();
    }
    else if (input.equals("3")) {
      if (mainPokemon instanceof ElectricPokemon electricPokemon)
        electricPokemon.increaseSpeed();
    }
  }

  public static void perfomChoiseChallenger(Pokemon mainPokemon, Pokemon challenger, String randomChoise) {
    if (randomChoise.equals("1")) {
      if (challenger instanceof FirePokemon firePokemon) {
        firePokemon.flameThrower(mainPokemon);
      }
      printOutValuesDefender(mainPokemon);
      System.out.println();
    }
    else if (randomChoise.equals("2")) {
      if (challenger instanceof FirePokemon firePokemon) {
        firePokemon.increaseFlameTemperature();
      }
      System.out.println();
    }
    else if (randomChoise.equals("3")) {
      if (challenger instanceof FirePokemon firePokemon) {
        firePokemon.increaseHeatShield();
      }
      System.out.println();
    }
  }
}

