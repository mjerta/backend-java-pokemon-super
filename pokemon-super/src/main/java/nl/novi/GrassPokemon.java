package nl.novi;

public class GrassPokemon extends Pokemon {

  private int leafSharpness; // adds up to the damage
  private int photosynthesisRate; // adds up to the defence

  public GrassPokemon(int level, int hp, int xp, double height, double weight, int defence) {
    super(level, hp, xp, height, weight, defence);
    super.setName("Bulbasaur");
    super.setType("Grass Pokemon");
    super.setSpecial("Boem");
  }

  @Override
  public void speaks() {
    System.out.println("Bulbasaaaarr");
  }

  public void razorLead(Pokemon challanger) {
    int damage;
    if (leafSharpness == 3) {
      damage = 100;
    } else {
      damage = 40;
    }
    int currentHp = challanger.getHp();
    int defence = challanger.getCurrentDefenceLevel();
    challanger.setHp(currentHp - damage + defence);
    challanger.resetDefenceLevel(); // This will reset the defence level to the base level challenger
    resetLeafSharpness(); // This will reset the main power to base level
    super.setAttack("razor lead");
    System.out.println("Bulbasaur razorleaf now!!");
  }

  // This is a method that will increase the damage
  public void increaseLeafSharpness() {
    // This method will increase the leafsharpness level each time, but it has a max of 3 times
    if (leafSharpness < 3) {
      leafSharpness++;
    } else {
      System.out.println("You've wasted your move, max of voltage has been reached");
    }
  }

  // This is a method that will increase the defance level
  public void increasePhotosynthesisRate() {
    if (photosynthesisRate == 2) {
      int defence = super.getDefaultDefenceLevel();
      defence += 30;
      super.setCurrentDefenceLevel(defence);
    } else if (photosynthesisRate < 2) {
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
