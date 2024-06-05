package nl.novi;

public class WaterPokemon extends Pokemon {

  private String attack;
  private int defense;

  public WaterPokemon(int level, int hp, int xp, double height, double weight, int defence) {
    super(level, hp, xp, height, weight, defence);
    super.setName("Squirtle");
    super.setType("Water Pokemon");
    super.setSpecial("Flussshhhh");
    defense = 20;
  }

  @Override
  public void speaks() {
    System.out.println("Squirtle Squitle");
  }

  public void watergun(Pokemon challanger) {
    int damage = 50;
    int currentHp = challanger.getHp();
    int defence = challanger.getDefence();
    challanger.setHp(currentHp - damage + defence);
    System.out.println("Squirtle watergun now!");
  }

  public String getAttack() {
    return attack;
  }

  public void setAttack(String attack) {
    this.attack = attack;
  }

}
