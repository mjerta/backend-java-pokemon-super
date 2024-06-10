package nl.novi;

public class WaterPokemon extends Pokemon {

  private int waterPressure; // adds up to damage
  private int swimmingSpeed; // adds up to the defence

  public WaterPokemon(int level, int hp, int xp, double height, double weight, int defence) {
    super(level, hp, xp, height, weight, defence);
    super.setName("Squirtle");
    super.setType("Water Pokemon");
    super.setSpecial("Flussshhhh");
    super.setAttack("water gun");
  }

  @Override
  public void speaks() {
    System.out.println("Squirtle Squitle");
  }

  public void waterGun(Pokemon challanger) {
    int damage;
    if (waterPressure >= 3) {
      damage = 80;
    } else {
      damage = 50;
    }
    int currentHp = challanger.getHp();
    int defence = challanger.getCurrentDefenceLevel();
    challanger.setHp(currentHp - damage + defence);
    challanger.resetDefenceLevel(); // This will reset the defence level to the base level of the challenger
    resetSwimmingSpeed(); // This will reset the main power to base level
    System.out.println("Squirtle watergun now!");
    System.out.println(challanger.getName() + " took a hit of " + damage);
  }

  // This is a method that will increase the damage
  public void increaseWaterPressure() {
    // This method will increase the voltage level each time, but it has a max of 3 times
    if (waterPressure < 3) {
      waterPressure++;
      System.out.println("Water pressure level is being added to " + super.getName());
    } else if (waterPressure == 3) {
      System.out.println("Lets go, your flame temperature has reach its maximum");
      waterPressure++;
    } else {
      System.out.println("You've wasted your move, max of water pressure has been reached");
    }
  }

  // This is a method that will increase the defance level
  public void increasSwimmingSpeed() {
    if (swimmingSpeed == 2) {
      System.out.println("Swimming speed level maximum is being reached to " + super.getName());
      int defence = super.getDefaultDefenceLevel();
      defence += 30;
      super.setCurrentDefenceLevel(defence);
    } else if (swimmingSpeed < 2) {
      System.out.println("Swimming speed level is being added to " + super.getName());
      swimmingSpeed++;
    } else {
      System.out.println("You've wasted your move, max of swimming speed has been reached");
    }
  }

  public void resetIncreaseWaterPressure() {
    waterPressure = 0;
  }

  public void resetSwimmingSpeed() {
    swimmingSpeed = 0;
  }
}