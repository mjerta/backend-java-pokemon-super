package nl.novi;

public class ElectricPokemon extends Pokemon {

  private int voltage; // adds to the damage
  private int speed; // adds to the defence

  public ElectricPokemon(int level, int hp, int xp, double height, double weight, int defence) {
    super(level, hp, xp, height, weight, defence);
    super.setName("Pikachu");
    super.setType("Grass Pokemon");
    super.setSpecial("Boem");
  }

  @Override
  public void speaks() {
    System.out.println("Pika Pika");
  }

  public void thunderShock(Pokemon challanger) {
    int damage = 60;
    int currentHp = challanger.getHp();
    int defence = challanger.getDefence();
    challanger.setHp(currentHp - damage + defence);
    super.setAttack("thunder shock");
    System.out.println("Pikachu tundershock now!!");
  }

  public void increaseVoltage() {
    voltage += 15;
  }

  public void increaseSpeed() {
    speed = 15;
  }

  public void resetVoltage() {
    voltage = 0;
  }

  public void resetSpeed() {
    speed = 0;
  }
}