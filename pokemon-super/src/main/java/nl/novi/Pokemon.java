package nl.novi;

public abstract class Pokemon {
  private String attack;
  private String name;
  private int level;
  private int hp;
  private int xp;
  private double height;
  private double weight;
  private String type;
  private String special;
  private int defaultDefenceLevel;
  private int currentDefenceLevel;

  public Pokemon(int level, int hp, int xp, double height, double weight, int defaultDefenceLevel) {
    this.level = level;
    this.hp = hp;
    this.xp = xp;
    this.height = height;
    this.weight = weight;
    this.defaultDefenceLevel = defaultDefenceLevel;
//    this.type = type;
//    this.special = special;
  }

  public String getAttack() {
    return attack;
  }

  public void setAttack(String attack) {
    this.attack = attack;
  }

  public void eat() {
    hp += 15;
  }

  public void resetDefenceLevel() {
    currentDefenceLevel = defaultDefenceLevel;
  }

  public abstract void speaks();

  public String getName() {
    return name;
  }

  public void setName(String name) {
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getSpecial() {
    return special;
  }

  public void setSpecial(String special) {
    this.special = special;
  }

  public int getDefaultDefenceLevel() {
    return defaultDefenceLevel;
  }

  public void setDefaultDefenceLevel(int defaultDefenceLevel) {
    this.defaultDefenceLevel = defaultDefenceLevel;
  }

  public int getCurrentDefenceLevel() {
    return currentDefenceLevel;
  }

  public void setCurrentDefenceLevel(int currentDefenceLevel) {
    this.currentDefenceLevel = currentDefenceLevel;
  }
}
