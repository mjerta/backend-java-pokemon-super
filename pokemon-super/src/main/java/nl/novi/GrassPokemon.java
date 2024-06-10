package nl.novi;

public class GrassPokemon extends Pokemon {

  private int leafSharpness; // adds up to the damage
  private int photosynthesisRate; // adds up to the defence

  public GrassPokemon(String name, int level, int hp, int xp, double height, double weight, int defence) {
    super(name, level, hp, xp, height, weight, defence);
    super.setType("Grass Pokemon");
    super.setSpecial("Boem");
    super.setAttack("razor lead");
  }

  @Override
  public void speaks() {
    System.out.println("Bulbasaaaarr");
  }

  public void razorLead(Pokemon challanger) {
    int damage;
    if (leafSharpness >= 3) {
      damage = 100;
    } else {
      damage = 40;
    }
    int currentHp = challanger.getHp();
    int defence = challanger.getCurrentDefenceLevel();
    challanger.setHp(currentHp - damage + defence);
    challanger.resetDefenceLevel(); // This will reset the defence level to the base level challenger
    resetLeafSharpness(); // This will reset the main power to base level
    System.out.println("Bulbasaur razorleaf now!!");
    System.out.println(challanger.getName() + " took a hit of " + damage);
  }

  // This is a method that will increase the damage
  public void increaseLeafSharpness() {
    // This method will increase the leafsharpness level each time, but it has a max of 3 times
    if (leafSharpness < 3) {
      leafSharpness++;
      System.out.println("Leaf sharpness pressure level is being added to " + super.getName());
    } else if (leafSharpness == 3) {
      System.out.println("Lets go, your leave sharpness level has reach its maximum");
      leafSharpness++;
    } else {
      System.out.println("You've wasted your move, max of voltage has been reached");
    }
  }

  // This is a method that will increase the defance level
  public void increasePhotosynthesisRate() {
    if (photosynthesisRate == 2) {
      System.out.println("Photo sytense rate level maximum is being reached to " + super.getName());
      int defence = super.getDefaultDefenceLevel();
      defence += 30;
      super.setCurrentDefenceLevel(defence);
    } else if (photosynthesisRate < 2) {
      System.out.println("Photo syntese rate level is being added to " + super.getName());
      photosynthesisRate++;
    } else {
      System.out.println("You've wasted your move, max of photosyntehisrate has been reached");
    }
  }

  public void resetLeafSharpness() {
    leafSharpness = 0;
  }

  public void resetPhotosynthesisRate() {
    photosynthesisRate = 0;
  }
}
