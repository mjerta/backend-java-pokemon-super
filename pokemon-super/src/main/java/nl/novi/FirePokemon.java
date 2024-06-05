package nl.novi;

public class FirePokemon extends Pokemon {

  private String attack;

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
    int defence = challanger.getDefence();
    challanger.setHp(currentHp - damage + defence);
    System.out.println("Charmender Flametrower now!!");
  }

  public String getAttack() {
    return attack;
  }

  public void setAttack(String attack) {
    this.attack = attack;
  }
}
