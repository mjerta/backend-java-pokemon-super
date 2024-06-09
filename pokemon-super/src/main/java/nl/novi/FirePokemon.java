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
    int damage;
    if (heatShield == 3) {
      damage = 70;
    } else {
      damage = 40;
    }
    int currentHp = challanger.getHp();
    int defence = challanger.getCurrentDefenceLevel();
    challanger.setHp(currentHp - damage + defence);
    challanger.resetDefenceLevel(); // This will reset the defence level to the base level of the challenger
    resetFlameTemperature(); // This will reset the main power to base level
    super.setAttack("flame thrower");
    System.out.println("Charmender Flametrower now!!");
  }

  // This is a method that will increase the damage
  public void increaseFlameTemperature() {
    // This method will increase the voltage level each time, but it has a max of 3 times
    if (flameTemperature < 3) {
      flameTemperature++;
    } else {
      System.out.println("You've wasted your move, max of flame temperature has been reached!!");
    }
  }

  // This is a method that will increase the defance level
  public void increaseHeatShield() {
    if (heatShield == 2) {
      int defence = super.getDefaultDefenceLevel();
      defence += 30;
      super.setCurrentDefenceLevel(defence);
    } else if (heatShield < 2) {
      heatShield++;
    } else {
      System.out.println("You've wasted your move, max of speed has been reached");
    }
  }

  public void resetFlameTemperature() {
    flameTemperature = 0;
  }

  public void resetHeatShield() {
    heatShield = 0;
  }
}
