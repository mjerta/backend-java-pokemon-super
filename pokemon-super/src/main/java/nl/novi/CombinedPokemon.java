package nl.novi;

public class CombinedPokemon extends Pokemon {
  Pokemon typeA;
  Pokemon typeB;

  public CombinedPokemon(String name, int level, int hp, int xp, double height, double weight, int defaultDefenceLevel, Pokemon typeA,
                         Pokemon typeB) {
    super(name, level, hp, xp, height, weight, defaultDefenceLevel);
    this.typeA = typeA;
    this.typeB = typeB;
  }

  @Override
  public void speaks() {
    System.out.println(super.getName() + "!!!");
  }
}
