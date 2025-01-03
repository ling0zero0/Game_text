package equipment;

public class Equipment {
    public String name;//姓名
    public int attack;//攻击力
    public int defense;//防御力

    public Equipment(String name, int attack, int defense) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {//get equipment name
        return name;
    }

    public int getAttack() {//get equipment attack
        return attack;
    }

    public int getDefense() {//get equipment defense
        return defense;
    }
}