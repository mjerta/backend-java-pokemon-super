package nl.novi;

public class ElectricPokemon extends Pokemon {

  private int voltage; // adds to the damage
  private int speed; // adds to the defence

  public ElectricPokemon(String name, int level, int hp, int xp, double height, double weight, int defaultDefenceLevel) {
    super(name, level, hp, xp, height, weight, defaultDefenceLevel);
    super.setType("Electric Pokemon");
    super.setSpecial("Boem");
    super.setDefenceName("speed");
    super.setPowerName("voltage");
    super.setAttack("thunder shock");
  }

  @Override
  public void speaks() {
    System.out.println("Pika Pika");
  }

  public void thunderShock(Pokemon challanger) {
    int damage;
    if (voltage >= 3) {
      damage = 90;
    } else {
      damage = 60;
    }
    int currentHp = challanger.getHp();
    int defence = challanger.getCurrentDefenceLevel();
    challanger.setHp(currentHp - damage + defence);
    challanger.resetDefenceLevel(); // This will reset the defence level to the base level of the challenger
    resetVoltage(); // This will reset the main power to base level
    System.out.println("Pikachu tundershock now!!");
    System.out.println(challanger.getName() + " took a hit of " + damage);
  }

  // This is a method that will increase the damage
  public void increaseVoltage() {
    // This method will increase the voltage level each time, but it has a max of 3 times
    if (voltage < 3) {
      voltage++;
      System.out.println("Voltage level is being added to " + super.getName());
    } else if (voltage == 3) {
      System.out.println("Lets go, your voltage level has reach its maximum ");
      voltage++;
    } else {
      System.out.println("You've wasted your move, max of voltage has been reached");
    }
  }

  // This is a method that will increase the defance level
  public void increaseSpeed() {
    if (speed == 2) {
      System.out.println("Speed level maximum is being reached to " + super.getName());
      int defence = super.getDefaultDefenceLevel();
      defence += 30;
      super.setCurrentDefenceLevel(defence);
    } else if (speed < 2) {
      System.out.println("Speed level is being added to " + super.getName());
      speed++;
    } else {
      System.out.println("You've wasted your move, max of speed has been reached");
    }
  }

  public void resetVoltage() {
    voltage = 0;
  }

  public void resetSpeed() {
    speed = 0;
  }
}