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

    // This pokemons need to be put into an array and there I will make a ramdom  object

//    FirePokemon charmender = new FirePokemon(50, 100, 0, 50, 50, 20);
//    WaterPokemon squirtle = new WaterPokemon(50, 100, 0, 50, 50, 20);
//    GrassPokemon bulbasaur = new GrassPokemon(50, 100, 0, 50, 50, 30);
    ElectricPokemon pikachu = new ElectricPokemon(50, 100, 0, 50, 50, 30);

    List<Pokemon> pokemons = new ArrayList<Pokemon>();
    pokemons.add(new FirePokemon(50, 100, 0, 50, 50, 20));
    pokemons.add(new WaterPokemon(50, 100, 0, 50, 50, 20));
    pokemons.add(new GrassPokemon(50, 100, 0, 50, 50, 30));

    //  scenarios can play out here
    // When everything is set up I want to be able to base on a scanner system to give a randon challenger

    // Randomize pokemon
    Random random = new Random();
    int randomIndex = random.nextInt(pokemons.size());
    Pokemon randomPokemon = pokemons.get(randomIndex);
    System.out.println(randomPokemon);

    // the followqing will cast the instance of into the specific type

    // the fight scene could be appearing inside of the if statement
    if (randomPokemon instanceof FirePokemon) {
      FirePokemon firePokemon = (FirePokemon) randomPokemon;
      firePokemon.speaks();
      System.out.println("Goodluck, your challenger is " + firePokemon.getName());

      // create a while loop to continue a challenge
    } else if (randomPokemon instanceof WaterPokemon) {
      WaterPokemon waterPokemon = (WaterPokemon) randomPokemon;
      waterPokemon.speaks();
      System.out.println(waterPokemon.getHp());
      System.out.println("Goodluck, your challenger is " + waterPokemon.getName());
      ;
    } else if (randomPokemon instanceof GrassPokemon) {
      GrassPokemon grassPokemon = (GrassPokemon) randomPokemon;
      grassPokemon.speaks();
      System.out.println(grassPokemon.getHp());
      System.out.println("Goodluck, your challenger is " + grassPokemon.getName());
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

    Scanner scanner = new Scanner(System.in);

  }

  // this game will just give a couple of choises:
  //  _ start the game
  //  - choose attack
  //  - eat - to regain hp

  // with every draw there will be a report of the damage being done and the current hp
  // when there is a winner this will be printed out

  // eventually when you win you continue to the next pokemons
  // if you win 4 times in a row you wil win a trofea

}