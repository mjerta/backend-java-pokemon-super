package nl.novi;

public class Main {

  // First i will one super class pokemon

  // I will make 4 sub classes ( this wil serve as fire, water, grass, and electric)

  // These will in turn also serve out as charmender, squirtle, bulbasaur and pikachu

  // Later i will make more subclasses so serve out more pokemon

  // First I will make 2 instances of different pokemons.
  // Then I will try to re-inact them to do a fight

  public static void main(String[] args) {

    FirePokemon charmender = new FirePokemon(50, 100, 0, 50, 50, 20);
    WaterPokemon squirtle = new WaterPokemon(50, 100, 0, 50, 50, 20);
    GrassPokemon bulbasaur = new GrassPokemon(50, 100, 0, 50, 50, 30);
    ElectricPokemon pikachu = new ElectricPokemon(50, 100, 0, 50, 50, 30);
    charmender.speaks();
    System.out.println("Hp of squirtle: " + squirtle.getHp());
    charmender.flameThrower(squirtle);
    System.out.println("Hp of squirtle: " + squirtle.getHp());
    squirtle.speaks();
    System.out.println("Hp of charmender: " + charmender.getHp());
    squirtle.waterGun(charmender);
    System.out.println("Hp of charmender: " + charmender.getHp());
    bulbasaur.speaks();
    pikachu.speaks();
    pikachu.thunderShock(squirtle);
    System.out.println("Hp of squirtle: " + squirtle.getHp());
  }

  // When everything is set up I want to be able to base on a scanner system to give a ramdon challenger

  // this game will just give a couple of choises:
  //  _ start the game
  //  - choose attack
  //  - eat - to regain hp

  // with every draw there will be a report of the damage being done and the current hp
  // when there is a winner this will be printed out

  // eventually when you win you continue to the next pokemons
  // if you win 4 times in a row you wil win a trofea

}