package nl.novi;

public class FirePokemon extends Pokemon {

  private int flameTemperature; // adds up to damage
  private int heatShield; // adds up to the defence

  public FirePokemon(int level, int hp, int xp, double height, double weight, int defence) {
    super(level, hp, xp, height, weight, defence);
    super.setName("Charmender");
    super.setType("Fire Pokemon");
    super.setSpecial("Boem");
  }

  @Override
  public void speaks() {
    System.out.println("Charmendaaaa");
  }

  public void flameThrower(Pokemon challanger) {
    int damage = 40;
    int currentHp = challanger.getHp();
    int defence = challanger.getCurrentDefenceLevel();
    challanger.setHp(currentHp - damage + defence);
    super.setAttack("flame thrower");
    System.out.println("Charmender Flametrower now!!");
  }

  public void increaseFlameTemperature() {
    flameTemperature += 15;
  }

  public void increaseHeatShield() {
    heatShield = 15;
  }

  public void resetFlameTemperature() {
    flameTemperature = 0;
  }

  public void resetHeatShield() {
    heatShield = 0;
  }
}
