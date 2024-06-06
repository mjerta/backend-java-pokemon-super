package nl.novi;

public class ElectricPokemon extends Pokemon {

  private int voltage; // adds to the damage
  private int speed; // adds to the defence

  public ElectricPokemon(int level, int hp, int xp, double height, double weight, int defaultDefenceLevel) {
    super(level, hp, xp, height, weight, defaultDefenceLevel);
    super.setName("Pikachu");
    super.setType("Grass Pokemon");
    super.setSpecial("Boem");
  }

  @Override
  public void speaks() {
    System.out.println("Pika Pika");
  }

  public void thunderShock(Pokemon challanger) {
    int damage;
    if (voltage == 45) {
      damage = 90;
    } else {
      damage = 60;
    }
    int currentHp = challanger.getHp();
    int defence = challanger.getCurrentDefenceLevel();
    challanger.setHp(currentHp - damage + defence);
    challanger.resetDefenceLevel();
    super.setAttack("thunder shock");
    System.out.println("Pikachu tundershock now!!");
  }

  public void increaseVoltage() {
    if (voltage < 45) {
      voltage += 15;
    } else {
      System.out.println("max of voltage has been reached");
    }
  }

  public void increaseSpeed() {
    if (speed == 30) {
      int defence = super.getDefaultDefenceLevel();
      defence += 30;
      super.setCurrentDefenceLevel(defence);
    } else if (speed < 30) {
      speed += 15;
    } else {
      System.out.println("max of speed has been reached");
    }
  }

  public void resetVoltage() {
    voltage = 0;
  }

  public void resetSpeed() {
    speed = 0;
  }
}