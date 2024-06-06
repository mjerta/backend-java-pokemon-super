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
    int damage = 40;
    int currentHp = challanger.getHp();
    int defence = challanger.getCurrentDefenceLevel();
    challanger.setHp(currentHp - damage + defence);
    challanger.resetDefenceLevel();
    super.setAttack("razor lead");
    System.out.println("Bulbasau rzaor now!!");
  }

  public void increaseLeafSharpness() {
    leafSharpness += 15;
  }

  public void increasePhotosynthesisRate() {
    photosynthesisRate = 15;
  }

  public void resetLeafSharpness() {
    leafSharpness = 0;
  }

  public void resetPhotosynthesisRate() {
    photosynthesisRate = 0;
  }
}
