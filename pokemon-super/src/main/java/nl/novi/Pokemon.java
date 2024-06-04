package nl.novi;

public abstract class Pokemon {
  private int name;
  private int level;
  private int hp;
  private int xp;
  private double height;
  private double weight;

  public Pokemon(int name, int level, int hp, int xp, double height, double weight) {
    this.name = name;
    this.level = level;
    this.hp = hp;
    this.xp = xp;
    this.height = height;
    this.weight = weight;
  }

  public int getName() {
    return name;
  }

  public void setName(int name) {
    this.name = name;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public int getXp() {
    return xp;
  }

  public void setXp(int xp) {
    this.xp = xp;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }
}
