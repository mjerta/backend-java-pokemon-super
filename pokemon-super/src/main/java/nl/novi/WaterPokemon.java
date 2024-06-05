package nl.novi;

public class WaterPokemon extends Pokemon {

  private int waterPressure; // adds up to damage
  private int swimmingSpeed; // adds up to the defence

  public WaterPokemon(int level, int hp, int xp, double height, double weight, int defence) {
    super(level, hp, xp, height, weight, defence);
    super.setName("Squirtle");
    super.setType("Water Pokemon");
    super.setSpecial("Flussshhhh");
  }

  @Override
  public void speaks() {
    System.out.println("Squirtle Squitle");
  }

  public void waterGun(Pokemon challanger) {
    int damage = 50;
    int currentHp = challanger.getHp();
    int defence = challanger.getDefence();
    challanger.setHp(currentHp - damage + defence);
    super.setAttack("water gun");
    System.out.println("Squirtle watergun now!");
  }

  public void increaseWaterPressure() {
    waterPressure += 15;
  }

  public void increasSwimmingSpeed() {
    swimmingSpeed = 15;
  }

  public void resetIncreaseWaterPressure() {
    waterPressure = 0;
  }

  public void resetIncreaseSwimmingSpeed() {
    swimmingSpeed = 0;
  }
}